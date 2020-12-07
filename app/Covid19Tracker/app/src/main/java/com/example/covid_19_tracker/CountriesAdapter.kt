package com.example.covid_19_tracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_tracker.R
import com.example.covid_19_tracker.models.Country
import com.example.covid_19_tracker.models.CountryName
import com.example.covid_19_tracker.models.CountryResponse

class CountriesAdapter(private var countries: List<CountryName>,private var clickListener: OnCountryItemClickListener) :
	RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
		ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))

	override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
		viewholder.init(countries[position], clickListener)
	}

	override fun getItemCount(): Int = countries.size

	interface OnCountryItemClickListener {
		fun onItemClick(item: CountryName, position: Int)
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private val countriyTextView: TextView = itemView.findViewById(R.id.movieItem)
		fun init(item: CountryName, action: OnCountryItemClickListener) {
			countriyTextView.text = item.country
			itemView.setOnClickListener() {
				action.onItemClick(item, adapterPosition)
			}
		}
	}

	fun clearAdapter() {
		countries = emptyList()
		notifyDataSetChanged()
	}

	fun setCountries(mvs: List<CountryName>) {
		countries = mvs
		notifyDataSetChanged()
	}

	fun getCountries(query : String) : List<CountryName>{
		Log.d("itt mi van","?")
		val c = countries.toMutableList()
		val new_c = c.filter { it.country.contains(query) }

		return new_c.toList()
	}
}