package com.example.innopolisonlinecinema.features.movie_player_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.innopolisonlinecinema.R
import com.example.innopolisonlinecinema.databinding.FragmentMoviePlayerBinding
import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.Util
import org.koin.android.ext.android.inject

class MoviePlayerFragment : Fragment(R.layout.fragment_movie_player) {
    companion object {
        private const val KEY_MOVIE = "movie"
        fun newInstance(movie: MovieDomainModel): MoviePlayerFragment {
            return MoviePlayerFragment().apply {
                arguments = bundleOf(Pair(KEY_MOVIE, movie))
            }
        }
    }

    private val player by inject<ExoPlayer>()
    private var _binding: FragmentMoviePlayerBinding? = null
    private val binding get() = _binding!!
    private val currentMovie: MovieDomainModel by lazy {
        requireArguments().getParcelable(KEY_MOVIE)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviePlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            pvMoviePlayer.player = player
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    private fun initializePlayer() {
        player.apply {
            setMediaItem(MediaItem.fromUri(currentMovie.video))
            playWhenReady = true
            prepare()
        }
    }

    override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT < 24)) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }


    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        player.run {
            playWhenReady = this.playWhenReady
            stop()
            release()
        }
    }
}