package com.example.covid_19_tracker.models

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
