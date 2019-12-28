package com.abrahamlay.newmovieapp.feature.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abrahamlay.domain.DefaultSubscriber
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.interactors.GetTopRatedMovies
import com.abrahamlay.newmovieapp.base.BaseViewModel
import com.abrahamlay.newmovieapp.constants.Constants

/**
 * Created by Abraham Lay on 2019-12-28.
 */
class TopRatedMovieViewModel(repositoryImpl: GetTopRatedMovies) : BaseViewModel() {
    private val mutableRepo = MutableLiveData<List<MovieModel>>()
    val movieData: LiveData<List<MovieModel>>
        get() = mutableRepo

    init {
        repositoryImpl.execute(object : DefaultSubscriber<List<MovieModel>>(){
            override fun onNext(data: List<MovieModel>) {
                super.onNext(data)
                mutableRepo.postValue(data)
            }
        },GetTopRatedMovies.Params(Constants.API_KEY))
    }
}