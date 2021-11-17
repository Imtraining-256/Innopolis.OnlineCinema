package com.example.innopolisonlinecinema.domain.model

class MovieDomainModel(
    val genres: List<MovieGenreDomainModel>,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val title: String,
    val video: String,
    val voteAverage: Double
)