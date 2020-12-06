package com.example.covid_19_tracker.utils

import android.graphics.Movie
import com.example.fragments.movie.network.models.Movie
import com.example.fragments.movie.network.models.MovieDetails

interface ServerResponseListener {
	fun getMovies(movies: List<Country>)
}

interface DetailsResponseListener{
	fun getDetails(details: MovieDetails?)
}