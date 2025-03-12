package com.example.moviekmm.data.repository

import com.example.moviekmm.data.remote.RemoteDataSource
import com.example.moviekmm.domain.model.Movie
import com.example.moviekmm.domain.repository.MovieRepository
import com.example.moviekmm.utils.toMovie

internal class MovieRepositoryImpl (private val remoteDataSource: RemoteDataSource) : MovieRepository{
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getSingleMovie(movieId: Int): Movie {
        return remoteDataSource.getSingleMovie(movieId = movieId).toMovie()
    }
}
