package com.example.lab_week_12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lab_week_12.model.Movie
import com.example.lab_week_12.api.MovieService

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "ce3e122b2a73fbe5401dd2a1147ee649"

    private val movieLiveData = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = movieLiveData

    private val errorLiveData = MutableLiveData<String>()
    val error: LiveData<String>
        get() = errorLiveData

    suspend fun fetchMovies() {
        try {
            val popularMovies = movieService.getPopularMovies(apiKey)
            movieLiveData.postValue(popularMovies.results)
        } catch (exception: Exception) {
            errorLiveData.postValue(
                "An error occurred: ${exception.message}"
            )
        }
    }
}
