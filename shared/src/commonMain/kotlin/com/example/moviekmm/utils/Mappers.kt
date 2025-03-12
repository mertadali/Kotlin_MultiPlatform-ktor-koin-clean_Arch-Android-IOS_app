package com.example.moviekmm.utils

import com.example.moviekmm.data.remote.MovieRemote
import com.example.moviekmm.domain.model.Movie

internal fun MovieRemote.toMovie() : Movie{
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImage : String) = "https://image.tmdb.org/t/p/w500/${posterImage}"


// bu sayede model kavramının sadece istemediğimiz keylerden kurtulmak için kullanılmadığı anlaşıldı.