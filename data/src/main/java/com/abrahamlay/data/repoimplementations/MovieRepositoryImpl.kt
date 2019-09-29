package com.abrahamlay.data.repoimplementations

import com.abrahamlay.data.apis.MovieAPI
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.repositories.MovieRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Abraham Lay on 2019-09-29.
 */


@Singleton
class MovieRepositoryImpl @Inject constructor(val api: MovieAPI) : MovieRepository {
    override fun getPopularMovies(apiKey: String): Flowable<List<MovieModel>> =
        api.getPopularMovies(apiKey).map {
            it.results.map { movie ->
                MovieModel(
                    movie.voteCount,
                    movie.id,
                    movie.video,
                    movie.voteAverage,
                    movie.originalTitle,
                    movie.popularity,
                    movie.posterPath,
                    movie.originalLanguage,
                    movie.originalTitle,
                    movie.genreIds,
                    movie.backdropPath,
                    movie.adult,
                    movie.overview,
                    movie.releaseDate

                )
            }
        }


    override fun getTopRatedMovies(apiKey: String): Flowable<List<MovieModel>> =
        api.getTopRatedMovies(apiKey).map {
            it.results.map { movie ->
                MovieModel(
                    movie.voteCount,
                    movie.id,
                    movie.video,
                    movie.voteAverage,
                    movie.originalTitle,
                    movie.popularity,
                    movie.posterPath,
                    movie.originalLanguage,
                    movie.originalTitle,
                    movie.genreIds,
                    movie.backdropPath,
                    movie.adult,
                    movie.overview,
                    movie.releaseDate

                )
            }
        }
}