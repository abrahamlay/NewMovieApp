package com.abrahamlay.data.apis

import com.abrahamlay.data.dtos.MovieDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Abraham Lay on 2019-09-29.
 */
interface MovieAPI {
    @GET("3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Flowable<MovieDto>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Flowable<MovieDto>
}