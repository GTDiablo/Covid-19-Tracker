package com.example.covid_19_tracker.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryResponse(
@Json(name = "country")
val Country : String,
@Json(name = "confirmed")
val Confirmed : Int,
@Json(name = "deaths")
val Deaths : Int,
@Json(name = "recovered")
val Recovered : Int,
@Json(name ="active")
val Active : Int
)
