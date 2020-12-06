
package com.example.fragments.movie.network.utils


import com.example.covid_19_tracker.api.CountryNamesApi
import com.example.covid_19_tracker.api.CountryResponseApi
import com.example.covid_19_tracker.models.CountryResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class CallBuilder() {
	private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
	private fun retrofit() = Retrofit.Builder()
		.baseUrl("https://api.covid19api.com/")
		.addConverterFactory(MoshiConverterFactory.create(moshi))
		.build()

	protected fun buildCountryNamesCall(): CountryNamesApi = retrofit().create(CountryNamesApi::class.java)
	protected fun buildPopularCall(): CountryResponseApi = retrofit().create(CountryResponseApi::class.java)
}