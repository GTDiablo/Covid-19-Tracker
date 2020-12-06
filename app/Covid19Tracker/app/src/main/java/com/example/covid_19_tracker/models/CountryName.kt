package com.example.covid_19_tracker.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryNames(
	val countries : List<CountryName>
)
@JsonClass(generateAdapter = true)
data class CountryName(
	@Json(name = "Country")
	val country: String,
	@Json(name = "Slug")
	val slug: String,
)