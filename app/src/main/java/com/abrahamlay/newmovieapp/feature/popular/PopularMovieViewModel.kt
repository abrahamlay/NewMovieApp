package com.abrahamlay.newmovieapp.feature.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.abrahamlay.base.constants.Constants
import com.abrahamlay.base.subscriber.BaseViewModel
import com.abrahamlay.base.subscriber.DefaultSubscriber
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.interactors.GetPopularMovies

/**
 * Created by Abraham Lay on 2019-10-06.
 */
class PopularMovieViewModel(repositoryImpl: GetPopularMovies) : BaseViewModel() {
    private val mutableRepo = MutableLiveData<List<MovieModel>>()
    private val triggerFetch = MutableLiveData<Boolean>()
    val movieData: LiveData<List<MovieModel>> = Transformations.switchMap(triggerFetch) {
        fetchMovie(repositoryImpl)
        return@switchMap mutableRepo
    }

    init {
        refreshMovie()
    }

    private fun fetchMovie(repositoryImpl: GetPopularMovies) {
        repositoryImpl.execute(object : DefaultSubscriber<List<MovieModel>>() {
            override fun onSuccess(data: List<MovieModel>) {
                mutableRepo.postValue(data)
            }
        }, GetPopularMovies.Params(Constants.API_KEY))
    }

    fun refreshMovie() {
        triggerFetch.value = true
    }
}