package com.abrahamlay.newmovieapp.module

import com.abrahamlay.data.repoimplementations.MovieRepositoryImpl
import com.abrahamlay.domain.repositories.MovieRepository
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val dataModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}