package com.example.covid_19_tracker.utils

import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.models.CountryName
import com.example.covid_19_tracker.models.CountryNames

interface ServerResponseListener {
	fun getCountry(countries: List<Country>)

}
interface CountryNamesListener {
	fun getAllCountries(allCountries:List<CountryName>)
}