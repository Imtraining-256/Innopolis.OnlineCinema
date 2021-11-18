package com.example.innopolisonlinecinema.features.movies_list_screen.ui

import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

data class ViewState(
    val movies: List<MovieDomainModel>,
    val errorMessage: String?,
)

sealed class UIEvent : Event {
    object GetMovies : UIEvent()
    data class OnMovieClick(val movie: MovieDomainModel) : UIEvent()
}

sealed class DataEvent : Event {
    data class SuccessMoviesRequest(val movies: List<MovieDomainModel>) : DataEvent()
    data class ErrorMoviesRequest(val errorMessage: String) : DataEvent()
}