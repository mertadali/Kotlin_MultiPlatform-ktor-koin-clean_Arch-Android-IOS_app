package com.example.moviekmm.di

import com.example.moviekmm.data.remote.MovieService
import com.example.moviekmm.data.remote.RemoteDataSource
import com.example.moviekmm.data.repository.MovieRepositoryImpl
import com.example.moviekmm.domain.repository.MovieRepository
import com.example.moviekmm.domain.usecase.GetMoviesUseCase
import com.example.moviekmm.domain.usecase.GetSingleMovieUseCase
import com.example.moviekmm.utils.provideDispatchers
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(),get()) }
    factory { MovieService() }
}

private val domainModule = module {
    factory { GetSingleMovieUseCase() }
    factory { GetMoviesUseCase() }
    single<MovieRepository> { MovieRepositoryImpl(get()) }

}

private val utilsModule = module {
    factory { provideDispatchers() }

}

private val sharedModules = listOf(dataModule,domainModule,utilsModule)

fun getSharedModules()  = sharedModules

