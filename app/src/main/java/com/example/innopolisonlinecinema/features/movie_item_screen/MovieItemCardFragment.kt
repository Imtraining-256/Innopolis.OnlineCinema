package com.example.innopolisonlinecinema.features.movie_item_screen

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.databinding.FragmentMovieItemCardBinding

class MovieItemCardFragment : Fragment(R.layout.fragment_movie_item_card) {
    companion object {
        fun newInstance() = MovieItemCardFragment()
    }

    private val binding: FragmentMovieItemCardBinding by viewBinding(FragmentMovieItemCardBinding::bind)
}