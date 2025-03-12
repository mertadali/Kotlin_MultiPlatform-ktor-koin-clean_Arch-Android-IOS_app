package com.example.moviekmm.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Kullanıcıya gösterilecek olan verilerimiz.

@Serializable
internal data class MovieRemote(
    val id : Int,
    val title  :String,
    val overview : String,
    @SerialName("poster_path")
    val posterImage  :String,
    @SerialName("release_date")
    val releaseDate  :String
)



