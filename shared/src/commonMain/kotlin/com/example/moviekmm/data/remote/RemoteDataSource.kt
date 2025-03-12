package com.example.moviekmm.data.remote

import com.example.moviekmm.utils.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(private val apiService : MovieService, private val dispatcher: Dispatcher){
    suspend fun getMovies(page : Int) = withContext(dispatcher.io){
        apiService.getPopularMovies(page=page)

    }

    suspend fun getSingleMovie(movieId : Int) = withContext(dispatcher.io){
        apiService.getPopularMovie(movieID = movieId)
    }

}