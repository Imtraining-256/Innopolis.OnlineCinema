package com.example.innopolisonlinecinema.features.movie_item_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.databinding.FragmentMovieItemCardBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

class MovieItemCardFragment : Fragment(R.layout.fragment_movie_item_card) {
    companion object {
        fun newInstance(movie: MovieDomainModel): MovieItemCardFragment {
            val args = Bundle()
            args.apply {
                putParcelable("movie", movie)
            }

            val fragment = MovieItemCardFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val binding: FragmentMovieItemCardBinding by viewBinding(FragmentMovieItemCardBinding::bind)
}