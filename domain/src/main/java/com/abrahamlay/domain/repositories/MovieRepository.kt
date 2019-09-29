package com.abrahamlay.domain.repositories

import com.abrahamlay.domain.entities.MovieModel
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */

interface MovieRepository {
    fun getPopularMovies(apiKey: String): Flowable<List<MovieModel>>
    fun getTopRatedMovies(apiKey: String): Flowable<List<MovieModel>>
}