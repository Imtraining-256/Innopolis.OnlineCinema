package com.example.innopolisonlinecinema.features.movie_item_screen

import com.example.innopolisonlinecinema.base.BaseViewModel
import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

class MovieItemCardViewModel(private val movie: MovieDomainModel) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(movie)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnPlayButtonListener -> {
                processUiEvent(UiEvent.OnPlayButtonListener(event.movie))
            }
        }
        return null
    }
}