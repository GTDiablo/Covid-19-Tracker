package com.example.covid_19_tracker.models

import com.squareup.moshi.Json

// itt lehet baj a generateJsonAdapter
data class CountryResponse(
	@Json(name = "Country")
	val country: String,
	@Json(name = "Confirmed")
	val confirmed: Int,
	@Json(name = "Deaths")
	val deaths: Int,
	@Json(name = "Recovered")
	val recovered: Int,
	@Json(name = "Active")
	val active: Int
)
