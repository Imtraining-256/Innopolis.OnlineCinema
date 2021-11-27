package com.example.innopolisonlinecinema.features.movie_item_screen.ui

import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

data class ViewState(
    val movie: MovieDomainModel
)

sealed class UIEvent : Event {
    data class OnPlayButtonClick(val movie: MovieDomainModel) : UIEvent()
}