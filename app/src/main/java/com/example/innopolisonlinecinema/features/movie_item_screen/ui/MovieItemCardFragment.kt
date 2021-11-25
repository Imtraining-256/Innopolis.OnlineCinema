package com.example.innopolisonlinecinema.features.movie_item_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.databinding.FragmentMovieItemCardBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieItemCardFragment : Fragment(R.layout.fragment_movie_item_card) {
    companion object {
        fun newInstance(movie: MovieDomainModel): MovieItemCardFragment {
            return MovieItemCardFragment().apply {
                arguments = bundleOf(Pair("movie", movie))
            }
        }
    }

    private val binding: FragmentMovieItemCardBinding by viewBinding(FragmentMovieItemCardBinding::bind)
    private val movie: MovieDomainModel by lazy {
        requireArguments().getParcelable("movie")!!
    }
    private val viewModel by viewModel<MovieItemCardViewModel> { parametersOf(movie) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvMovieTitle.text = movie.title
            btnPlay.setOnClickListener {
                viewModel.processUiEvent(UiEvent.OnPlayButtonListener(movie))
            }
        }
    }
}