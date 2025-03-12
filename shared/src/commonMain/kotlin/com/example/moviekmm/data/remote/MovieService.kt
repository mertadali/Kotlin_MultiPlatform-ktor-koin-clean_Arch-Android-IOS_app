package com.example.moviekmm.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi(){

    suspend fun getPopularMovies(page : Int = 1)  : MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page",page)

    }.body()

    suspend fun getPopularMovie(movieID : String) : MovieRemote = client.get {     // just getting single data
        pathUrl("movie/${movieID}")
    }.body()
}



