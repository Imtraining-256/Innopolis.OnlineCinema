package com.example.innopolisonlinecinema

import android.app.Application
import com.example.innopolisonlinecinema.di.appModule
import com.example.innopolisonlinecinema.di.navigationModule
import com.example.innopolisonlinecinema.features.movie_player_screen.di.exoPlayerModule
import com.example.innopolisonlinecinema.features.movies_list_screen.di.moviesListModule
import movieItemCardModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                moviesListModule,
                movieItemCardModule,
                exoPlayerModule,
                navigationModule
            )
        }
    }
}