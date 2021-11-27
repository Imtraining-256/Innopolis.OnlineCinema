package com.example.innopolisonlinecinema.features.movie_player_screen.ui

import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

data class ViewState(val movie: MovieDomainModel)

sealed class PlayerUiEvent : Event {
    data class OnPlayerStarted(val movie: MovieDomainModel) : PlayerUiEvent()
}