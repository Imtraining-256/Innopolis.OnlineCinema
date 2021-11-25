package com.example.innopolisonlinecinema.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieGenreDomainModel(
    val genre: String
) : Parcelable