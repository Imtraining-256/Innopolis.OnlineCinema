package com.example.innopolisonlinecinema.features.movie_item_screen

import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

data class ViewState(
    val movie: MovieDomainModel
)

sealed class UiEvent : Event {
    data class OnPlayButtonListener(val movie: MovieDomainModel) : UiEvent()
}