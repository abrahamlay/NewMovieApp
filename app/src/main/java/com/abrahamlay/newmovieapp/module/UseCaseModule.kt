package com.abrahamlay.newmovieapp.module

import com.abrahamlay.domain.AndroidUIThread
import com.abrahamlay.domain.PostExecutionThread
import com.abrahamlay.domain.interactors.GetPopularMovies
import com.abrahamlay.domain.interactors.GetTopRatedMovies
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val useCaseModule = module {
    single<PostExecutionThread> { return@single AndroidUIThread() }
    factory { GetPopularMovies(get(), get()) }
    factory { GetTopRatedMovies(get(), get()) }
}