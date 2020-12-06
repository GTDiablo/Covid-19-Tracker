package com.example.covid_19_tracker.utils

import android.util.Log
import com.example.fragments.movie.network.utils.CallBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MovieController() : CallBuilder() {

	fun searchCountries(query: String, serverResponseListener: ServerResponseListener) {
		makeCountriesCall(query, serverResponseListener)
	}

	fun getAllCountries(movie_Id:Int,detailsResponseListener: DetailsResponseListener){
		makeCountriesCall(movie_Id,detailsResponseListener)
	}

	private fun makeCountriesCall(query: String, serverResponseListener: ServerResponseListener) {
		buildMoviesCall().listMovies(MOVIE_DB_API_KEY, query).enqueue(object : Callback<MovieResponse> {
			override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
				val movieResponse = response.body()
				movieResponse?.results?.let { serverResponseListener.getMovies(it) }
			}

			override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
				Log.e(MovieController::class.java.simpleName, t.message!!)
			}
		})
	}

}