package com.example.innopolisonlinecinema.base.navigation

import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.example.innopolisonlinecinema.features.movie_item_screen.ui.MovieItemCardFragment
import com.example.innopolisonlinecinema.features.movie_player_screen.ui.MoviePlayerFragment
import com.example.innopolisonlinecinema.features.movies_list_screen.ui.MoviesListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun moviesListScreen() = FragmentScreen {
        MoviesListFragment().newInstance()
    }

    fun movieItemCardScreen(movie: MovieDomainModel) = FragmentScreen {
        MovieItemCardFragment.newInstance(movie)
    }

    fun moviePlayerScreen(movie: MovieDomainModel) = FragmentScreen {
        MoviePlayerFragment.newInstance(movie)
    }
}