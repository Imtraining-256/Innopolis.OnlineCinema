package com.example.innopolisonlinecinema.features.movie_item_screen.ui

import com.example.innopolisonlinecinema.base.BaseViewModel
import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.base.navigation.Screens
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.github.terrakok.cicerone.Router

class MovieItemCardViewModel(private val movie: MovieDomainModel, private val router: Router) :
    BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(movie)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnPlayButtonClick -> {
                router.navigateTo(Screens.moviePlayerScreen(event.movie))
            }
        }
        return null
    }
}