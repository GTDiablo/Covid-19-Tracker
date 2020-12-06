package com.example.covid_19_tracker.models

import com.squareup.moshi.Json

data class CountryNames(
	val countries : List<CountryName>
)

data class CountryName(
	@Json(name = "Country")
	val country: String,
	@Json(name = "Slug")
	val slug: String,
)