package com.example.covid_19_tracker.api

import com.example.covid_19_tracker.models.CountryNames
import com.example.covid_19_tracker.models.CountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryNamesApi {
	@GET("countries")
	fun getAllCountries(user: String?): Call<CountryNames>
}