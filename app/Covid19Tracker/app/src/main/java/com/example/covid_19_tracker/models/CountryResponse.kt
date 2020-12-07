package com.example.covid_19_tracker.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
// itt lehet baj a generateJsonAdapter
data class CountryResponse(
	val data : List<Country>
)
@JsonClass(generateAdapter = true)
data class Country(
	@Json(name = "Country")
	val country: String,
	@Json(name = "Confirmed")
	val confirmed: Int,
	@Json(name = "Deaths")
	val deaths: Int,
	@Json(name = "Recovered")
	val recovered: Int,
	@Json(name = "Active")
	val active: Int,
	@Json(name = "Date")
	val date : String
)
