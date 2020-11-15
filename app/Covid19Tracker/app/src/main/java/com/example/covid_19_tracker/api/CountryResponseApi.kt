package com.example.covid_19_tracker.api

import com.example.covid_19_tracker.models.CountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryResponseApi {
	@GET("live/country/{country}")
	fun getInfo(@Path("country") user: String?): Call<List<CountryResponse>>
}