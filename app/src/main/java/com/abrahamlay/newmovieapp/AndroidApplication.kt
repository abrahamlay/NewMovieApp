package com.abrahamlay.newmovieapp

import android.app.Application
import com.abrahamlay.newmovieapp.module.apiModule
import com.abrahamlay.newmovieapp.module.dataModule
import com.abrahamlay.newmovieapp.module.useCaseModule
import com.abrahamlay.newmovieapp.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Abraham Lay on 2019-10-06.
 */
class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(
                listOf(
                    dataModule,
                    apiModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}