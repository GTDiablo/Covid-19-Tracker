package com.example.covid_19_tracker.utils

import android.util.Log
import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.models.CountryName
import com.example.fragments.movie.network.utils.CallBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class CountriesController() : CallBuilder() {

	fun getCountry(query: String, serverResponseListener: ServerResponseListener) {
		makeCountriesCall(query, serverResponseListener)
	}

	fun getAll(countryNamesListener: CountryNamesListener){
		makeAllCountriesCall(countryNamesListener)
	}

	private fun makeCountriesCall(query: String, serverResponseListener: ServerResponseListener) {
		buildCountryCall().getCountry(query).enqueue(object : Callback<List<Country>> {
			override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
				val countryResponse = response.body()
				countryResponse?.let { serverResponseListener.getCountry(it) }
			}

			override fun onFailure(call: Call<List<Country>>, t: Throwable) {
				Log.e(CountriesController::class.java.simpleName, t.message!!)

			}
		})
	}


	private fun makeAllCountriesCall(countryNamesListener: CountryNamesListener) {
		buildCountryNamesCall().getAllCountries().enqueue(object : Callback<List<CountryName>> {
			override fun onResponse(call: Call<List<CountryName>>, response: Response<List<CountryName>>) {
				val countryNamesResponse: List<CountryName>? = response.body()
				countryNamesResponse?.let{ countryNamesListener.getAllCountries(it) }

			}

			override fun onFailure(call: Call<List<CountryName>>, t: Throwable) {
				Log.e(CountriesController::class.java.simpleName, t.message!!)
			}
		})
	}

}