package com.abrahamlay.newmovieapp.module

import com.abrahamlay.home.popular.PopularMovieViewModel
import com.abrahamlay.home.toprated.TopRatedMovieViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val viewModelModule = module {
    viewModel<PopularMovieViewModel>()
    viewModel<TopRatedMovieViewModel>()
}