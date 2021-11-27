package com.example.innopolisonlinecinema.features.movie_item_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.base.formatDate
import com.example.innopolisonlinecinema.databinding.FragmentMovieItemCardBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.example.innopolisonlinecinema.features.movie_player_screen.ui.MoviePlayerFragment

class MovieItemCardFragment : Fragment(R.layout.fragment_movie_item_card) {
    private var _binding: FragmentMovieItemCardBinding? = null
    private val binding get() = _binding!!
    private val currentMovie: MovieDomainModel by lazy {
        requireArguments().getParcelable(KEY_MOVIE)!!
    }

    companion object {
        private const val KEY_MOVIE = "movie"
        fun newInstance(movie: MovieDomainModel): MovieItemCardFragment {
            return MovieItemCardFragment().apply {
                arguments = bundleOf(Pair(KEY_MOVIE, movie))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieItemCardBinding.inflate(inflater, container, false)
        return binding.root
    }

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
                parentFragmentManager.beginTransaction()
                    .add(
                        android.R.id.content,
                        MoviePlayerFragment.newInstance(movie = currentMovie)
                    )
                    .addToBackStack("card").commit()
            }
        }
    }
}