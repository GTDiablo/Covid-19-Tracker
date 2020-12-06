package com.example.covid_19_tracker.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_tracker.CountriesAdapter
import com.example.covid_19_tracker.R
import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.utils.CountriesController
import com.example.covid_19_tracker.utils.ServerResponseListener
import java.util.Timer
import java.util.TimerTask

class DashboardFragment() : Fragment(), CountriesAdapter.OnCountryItemClickListener {

	val countriesController = CountriesController()
	lateinit var countriesAdapter: CountriesAdapter
	private var timer = Timer()
	private val delay : Long = 500

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {

		val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
		initSearchBar(rootView)
		initRecyclerView(rootView)
		return rootView
	}


	override fun onItemClick(item: Country, position: Int) {
		val bundle = Bundle()
		bundle.putString("countryName", item.country)
		val detailsFragment = DetailsFragment()
		detailsFragment.arguments = bundle
		switchToDetailsFragment(detailsFragment)
	}

	private fun switchToDetailsFragment(fragment: Fragment) {
		requireActivity().supportFragmentManager.beginTransaction().run {
			replace(R.id.fragment_container, fragment)
			addToBackStack(null)
			commit()
		}
	}

	private fun timerSchedule(timer: Timer, executeUnit: () -> Unit) {
		timer.schedule(object : TimerTask() {
			override fun run() {
				requireActivity().runOnUiThread {
					executeUnit()
				}
			}
		}, delay)
	}

	private fun initRecyclerView(view: View) {
		val rvCountries = view.findViewById<View>(R.id.countriesRecyclerView) as? RecyclerView
		countriesAdapter = CountriesAdapter(listOf(), this)
		rvCountries?.layoutManager = LinearLayoutManager(this.requireContext())
		rvCountries?.adapter = countriesAdapter
	}

	private fun initSearchBar(view: View) {

		val searchBar = view.findViewById<EditText>(R.id.searchBar)
		searchBar!!.addTextChangedListener(object : TextWatcher {
			override fun afterTextChanged(s: Editable?) {
				if (searchBar.text.isNotEmpty()){
					timer.cancel()
					timer = Timer()
					fillMovieList(searchBar.text.toString())
				}

			}


			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/*no-op*/
			}

			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {/*no-op*/
			}
		}
		)
	}

	private fun fillMovieList(query: String) {
		val countriesController = CountriesController()
		countriesController.getCountry(query, object : ServerResponseListener {
			override fun getCountry(countries : List<Country>) {
				if (countries.isNotEmpty()) {
					timerSchedule(timer) { countriesAdapter.setCountries(countries) }
				} else {
					timerSchedule(timer) {
						countriesAdapter.clearAdapter()
						Toast.makeText(
							requireActivity().applicationContext,
							"Couldn't find any movies that matches : $query",
							Toast.LENGTH_LONG
						).show()
					}
				}
			}
		})
	}

}
