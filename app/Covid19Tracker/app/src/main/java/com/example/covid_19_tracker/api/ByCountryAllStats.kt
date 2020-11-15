package com.example.covid_19_tracker.api

interface ByCountryAllStats {
	@GET("users/{user}/repos")
	fun listRepos(@Path("user") user: String?): Call<List<Repo?>?>?
}