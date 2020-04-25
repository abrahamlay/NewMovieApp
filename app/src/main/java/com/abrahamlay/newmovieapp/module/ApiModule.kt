package com.abrahamlay.newmovieapp.module

import com.abrahamlay.newmovieapp.WebApiProvider
import com.abrahamlay.data.apis.MovieAPI
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val apiModule = module {
    single { WebApiProvider }
    single {
        get<WebApiProvider>()
            .getRetrofit()
            .create(MovieAPI::class.java)
    }
}