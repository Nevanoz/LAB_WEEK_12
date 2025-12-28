package com.example.lab_week_12.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.lab_week_12.model.PopularMoviesResponse

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): PopularMoviesResponse
}
