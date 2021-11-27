package com.example.innopolisonlinecinema.features.movies_list_screen.ui

import com.example.innopolisonlinecinema.base.BaseViewModel
import com.example.innopolisonlinecinema.base.Event
import com.example.innopolisonlinecinema.base.navigation.Screens
import com.example.innopolisonlinecinema.domain.MovieInteractor
import com.github.terrakok.cicerone.Router

class MoviesListViewModel(private val interactor: MovieInteractor, private val router: Router) :
    BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.GetMovies)
    }

    override fun initialViewState(): ViewState {
        return ViewState(movies = listOf(), errorMessage = null, isLoad = false)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.GetMovies -> {
                interactor.getMovies().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessMoviesRequest(it))
                    },
                    onError = {
                        processDataEvent(DataEvent.ErrorMoviesRequest(it.localizedMessage ?: ""))
                    }
                )
            }

            is UIEvent.OnMovieClick -> {
                router.navigateTo(Screens.movieItemCardScreen(event.movie))
            }

            is DataEvent.SuccessMoviesRequest -> {
                return previousState.copy(
                    movies = event.movies,
                    errorMessage = null,
                    isLoad = false
                )
            }

            is DataEvent.ErrorMoviesRequest -> {
                return previousState.copy(
                    errorMessage = event.errorMessage
                )
            }
        }

        return null
    }
}