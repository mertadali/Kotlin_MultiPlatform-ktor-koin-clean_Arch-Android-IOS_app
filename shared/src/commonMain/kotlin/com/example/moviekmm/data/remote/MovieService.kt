package com.example.moviekmm.data.remote

import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi(){

    suspend fun getPopularMovies() = client.get {
        pathUrl("movie/popular")
        parameter("page",1)

    }

    suspend fun getPopularMovie(movieID : String) = client.get {
        pathUrl("movie/${movieID}")
    }

}