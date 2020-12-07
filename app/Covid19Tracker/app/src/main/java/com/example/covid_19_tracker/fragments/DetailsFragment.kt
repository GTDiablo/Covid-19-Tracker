package com.example.covid_19_tracker.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid_19_tracker.R
import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.models.CountryName
import com.example.covid_19_tracker.utils.CountriesController
import com.example.covid_19_tracker.utils.ServerResponseListener
import kotlinx.android.synthetic.main.fragment_details.active_text
import kotlinx.android.synthetic.main.fragment_details.confirmed_text
import kotlinx.android.synthetic.main.fragment_details.date_text
import kotlinx.android.synthetic.main.fragment_details.death_text
import kotlinx.android.synthetic.main.fragment_details.recovered_text

class DetailsFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? = inflater.inflate(R.layout.fragment_details, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val countryName = arguments?.getString("countryName")
		getDetailsData(countryName.toString())
	}

	private fun getDetailsData(countryName: String){
		val countriesController = CountriesController()
			countriesController.getCountry(countryName,object : ServerResponseListener{
				override fun getCountry(details: List<Country>) {
					details?.run {
						val data = details.last()
						active_text.text = "Active\n"+data.active.toString()
						recovered_text.text = "Recovered\n"+data.recovered.toString()
						confirmed_text.text = "Confirmed\n"+data.confirmed.toString()
						death_text.text = "Deaths\n"+data.deaths.toString()
						date_text.text = "Timestamp\n"+data.date
					}
				}
			}) }
	}
