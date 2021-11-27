package com.example.innopolisonlinecinema.features.movie_player_screen.di

import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val exoPlayerModule = module {
    factory<ExoPlayer> {
        SimpleExoPlayer.Builder(androidApplication()).build()
    }
}