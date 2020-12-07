package com.example.covid_19_tracker.api

import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.models.CountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryResponseApi {
	@GET("total/country/{country}")
	fun getCountry(@Path("country") user: String): Call<List<Country>>
}