package com.example.innopolisonlinecinema.data.api

import com.example.innopolisonlinecinema.data.api.model.Results

class MoviesRemoteSource(private val api: MoviesApi) {
    suspend fun fetchMovies(): Results {
        return api.getMovies()
    }
}