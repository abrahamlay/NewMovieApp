package com.abrahamlay.newmovieapp.feature

import com.abrahamlay.domain.entities.MovieModel

/**
 * Created by Abraham Lay on 2019-12-28.
 */

interface ViewContract{
    fun onMovieLoaded(list: List<MovieModel>)
}