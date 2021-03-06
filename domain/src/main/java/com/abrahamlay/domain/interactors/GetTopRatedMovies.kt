package com.abrahamlay.domain.interactors

import com.abrahamlay.domain.PostExecutionThread
import com.abrahamlay.domain.UseCase
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.repositories.MovieRepository
import io.reactivex.Flowable


/**
 * Created by Abraham Lay on 2019-09-29.
 */
class GetTopRatedMovies constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : UseCase<List<MovieModel>, GetTopRatedMovies.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<MovieModel>> = repository.getTopRatedMovies(params.apiKey)

    data class Params(val apiKey: String)
}