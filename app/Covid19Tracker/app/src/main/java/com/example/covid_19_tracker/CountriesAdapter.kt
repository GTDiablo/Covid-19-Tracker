package com.example.covid_19_tracker

package com.example.fragments.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_tracker.R
import com.example.covid_19_tracker.models.CountryResponse

class CountriesAdapter(private var movies: List<CountryResponse>,private var clickListener: OnMovieItemClickListener) :
	RecyclerView.Adapter<CountryResponse.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
		ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

	override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
		viewholder.init(movies[position], clickListener)
	}

	override fun getItemCount(): Int = movies.size

	interface OnMovieItemClickListener {
		fun onItemClick(item: Movie, position: Int)
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private val movieTitleView: TextView = itemView.findViewById(R.id.movieItem)
		fun init(item: Movie, action: OnMovieItemClickListener) {
			movieTitleView.text = item.title
			itemView.setOnClickListener() {
				action.onItemClick(item, adapterPosition)
			}
		}
	}

	fun clearAdapter() {
		movies = emptyList()
		notifyDataSetChanged()
	}

	fun setMovies(mvs: List<Movie>) {
		movies = mvs
		notifyDataSetChanged()
	}
}