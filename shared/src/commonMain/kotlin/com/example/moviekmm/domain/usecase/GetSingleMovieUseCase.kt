package com.example.moviekmm.domain.usecase

import com.example.moviekmm.domain.model.Movie
import com.example.moviekmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetSingleMovieUseCase() : KoinComponent{
    private val repository : MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieId : Int) : Movie{
        return repository.getSingleMovie(movieId = movieId)
    }



}