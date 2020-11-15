
package com.example.fragments.movie.network.utils


import com.example.covid_19_tracker.api.CountryResponseApi
import com.example.covid_19_tracker.models.CountryResponse
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class CallBuilder() {
	private fun retrofit() = Retrofit.Builder()
		.baseUrl("https://api.example.com")
		.addConverterFactory(MoshiConverterFactory.create())
		.build()

	protected fun buildCountriesCall(): CountryResponseApi = retrofit().create(CountryResponseApi::class.java)
}