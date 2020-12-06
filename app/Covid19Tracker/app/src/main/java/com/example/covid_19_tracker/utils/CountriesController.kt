package com.example.covid_19_tracker.utils

import android.util.Log
import com.example.covid_19_tracker.models.CountryNames
import com.example.covid_19_tracker.models.CountryResponse
import com.example.fragments.movie.network.utils.CallBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class CountriesController() : CallBuilder() {

	fun getCountry(query: String, serverResponseListener: ServerResponseListener) {
		makeCountriesCall(query, serverResponseListener)
	}

	fun getAllCountries(countryNamesListener: CountryNamesListener){
		makeAllCountriesCall(countryNamesListener)
	}

	private fun makeCountriesCall(query: String, serverResponseListener: ServerResponseListener) {
		buildCountryCall().getCountry(query).enqueue(object : Callback<CountryResponse> {
			override fun onResponse(call: Call<CountryResponse>, response: Response<CountryResponse>) {
				val countryResponse = response.body()
				countryResponse?.data?.let { serverResponseListener.getCountry(it) }
			}

			override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
				Log.e(CountriesController::class.java.simpleName, t.message!!)
			}
		})
	}


	private fun makeAllCountriesCall(countryNamesListener: CountryNamesListener) {
		buildCountryNamesCall().getAllCountries().enqueue(object : Callback<CountryNames> {
			override fun onResponse(call: Call<CountryNames>, response: Response<CountryNames>) {
				val countryNamesResponse: CountryNames? = response.body()
				countryNamesResponse?.countries?.let{ countryNamesListener.getAllCountries(it) }
			}

			override fun onFailure(call: Call<CountryNames>, t: Throwable) {
				Log.e(CountriesController::class.java.simpleName, t.message!!)
			}
		})
	}

}