package com.example.innopolisonlinecinema.features.movie_item_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.databinding.FragmentMovieItemCardBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel

class MovieItemCardFragment : Fragment(R.layout.fragment_movie_item_card) {
    private var _binding: FragmentMovieItemCardBinding? = null
    private val binding get() = _binding!!

    private val currentMovie: MovieDomainModel by lazy {
        requireArguments().getParcelable("movie")!!
    }

    companion object {
        fun newInstance(movie: MovieDomainModel): MovieItemCardFragment {
            return MovieItemCardFragment().apply {
                arguments = bundleOf(Pair("movie", movie))
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
        }
    }
}