package com.example.innopolisonlinecinema.features.movie_item_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.base.formatDate
import com.example.innopolisonlinecinema.databinding.FragmentMovieItemCardBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieItemCardFragment : Fragment(R.layout.fragment_movie_item_card) {
    companion object {
        private const val KEY_MOVIE = "movie"
        fun newInstance(movie: MovieDomainModel): MovieItemCardFragment {
            return MovieItemCardFragment().apply {
                arguments = bundleOf(Pair(KEY_MOVIE, movie))
            }
        }
    }

    private val binding: FragmentMovieItemCardBinding by viewBinding(FragmentMovieItemCardBinding::bind)
    private val currentMovie: MovieDomainModel by lazy {
        requireArguments().getParcelable(KEY_MOVIE)!!
    }
    private val viewModel: MovieItemCardViewModel by viewModel { parametersOf(currentMovie) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvMovieTitle.text = currentMovie.title
            tvGeneres.text = currentMovie.genres.joinToString { genere -> genere.genre }
            tvMovieRating.text = currentMovie.voteAverage.toString()
            tvMovieDescription.text = currentMovie.overview
            tvMovieReleaseDate.text = formatDate(currentMovie.releaseDate)
            context?.let {
                Glide.with(it).load(currentMovie.posterPath).into(ivPoster)
            }
            btnPlay.setOnClickListener {
                viewModel.processUiEvent(UIEvent.OnPlayButtonClick(currentMovie))
            }
        }
    }
}