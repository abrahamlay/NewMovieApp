package com.abrahamlay.newmovieapp.feature.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abrahamlay.domain.DefaultSubscriber
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.interactors.GetPopularMovies
import com.abrahamlay.newmovieapp.base.BaseViewModel
import com.abrahamlay.newmovieapp.constants.Constants

/**
 * Created by Abraham Lay on 2019-10-06.
 */
class PopularMovieViewModel(repositoryImpl: GetPopularMovies) : BaseViewModel() {
    private val mutableRepo = MutableLiveData<List<MovieModel>>()
    val movieData: LiveData<List<MovieModel>>
        get() = mutableRepo

    init {
        repositoryImpl.execute(object : DefaultSubscriber<List<MovieModel>>() {
            override fun onNext(data: List<MovieModel>) {
                super.onNext(data)
                mutableRepo.postValue(data)
            }
        }, GetPopularMovies.Params(Constants.API_KEY))
    }
}