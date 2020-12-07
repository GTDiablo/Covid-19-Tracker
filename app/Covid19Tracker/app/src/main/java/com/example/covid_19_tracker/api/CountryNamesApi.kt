package com.example.covid_19_tracker.api

import com.example.covid_19_tracker.models.CountryName
import retrofit2.Call
import retrofit2.http.GET

interface CountryNamesApi {
	@GET("countries")
	fun getAllCountries(): Call<List<CountryName>>
}