package com.example.covid_19_tracker.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_tracker.CountriesAdapter
import com.example.covid_19_tracker.R
import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.models.CountryName
import com.example.covid_19_tracker.utils.CountriesController
import com.example.covid_19_tracker.utils.CountryNamesListener
import com.example.covid_19_tracker.utils.ServerResponseListener
import kotlinx.android.synthetic.main.fragment_dashboard.searchBar
import kotlinx.android.synthetic.main.fragment_details.detailsFragment
import java.util.Timer
import java.util.TimerTask

class DashboardFragment() : Fragment(), CountriesAdapter.OnCountryItemClickListener {

	val countriesController = CountriesController()
	lateinit var countriesAdapter: CountriesAdapter
	val _countries = listOf<CountryName>()
	private var timer = Timer()
	private val delay: Long = 200

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		fillAllCountriesList()
		val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
		initSearchBar(rootView)
		initRecyclerView(rootView)
		return rootView
	}

	override fun onItemClick(item: CountryName, position: Int) {
		val bundle = Bundle()
		bundle.putString("countryName", item.slug)
		Log.d("country:", item.slug)
		val detailsFragment = DetailsFragment()
		detailsFragment.arguments = bundle
		switchToDetailsFragment(detailsFragment)
	}

	private fun switchToDetailsFragment(fragment: Fragment) {
		requireActivity().supportFragmentManager.beginTransaction().run {
			replace(R.id.fragment_container, fragment)
			addToBackStack(null)
			commit()
			Log.d("GO BRO", "WTF")
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
				if (searchBar.text.isNotEmpty()) {
					timer.cancel()
					timer = Timer()
					fillCountryList(searchBar.text.toString())
				}
				else {
					fillAllCountriesList()
				}

			}

			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/*no-op*/
			}

			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {/*no-op*/
			}
		}
		)
	}

	private fun fillAllCountriesList() {
		countriesController.getAll(object : CountryNamesListener {
			override fun getAllCountries(countries: List<CountryName>) {
				countriesAdapter.setCountries(countries)
			}
		})

	}

	private fun fillCountryList(query:String){
		val button = view!!.findViewById<ImageButton>(R.id.searchBtn)
		button.setOnClickListener{
			val c = countriesAdapter.getCountries(query)
			if (c.isNotEmpty()) {
				timerSchedule(timer) { countriesAdapter.setCountries(c)}
			} else {
				timerSchedule(timer) {
					countriesAdapter.clearAdapter()
					Toast.makeText(
						requireActivity().applicationContext,
						"Couldn't find any movies that matches : ",
						Toast.LENGTH_LONG
					).show()
				}
			}
		}

	}
}

