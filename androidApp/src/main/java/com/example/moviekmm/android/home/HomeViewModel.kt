package com.example.moviekmm.android.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviekmm.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel (val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadMovies(forceReload = false)
    }

    fun loadMovies(forceReload : Boolean = false){

        if(uiState.loading){         // ilk etapta boş döndürdük zaten ilk değer false
            return
        }

        if (forceReload){     // kullanıcı sayfayı refreslemeye çalışıyorsa 1. sayfaya gitmeye çalışıyordur.
            currentPage = 1
        }

        if (currentPage == 1){
            uiState = uiState.copy(refreshing = true)
        }

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            try {
                val resultMovies = getMoviesUseCase.invoke(page = currentPage)
                val lastMovies = if (currentPage==1) resultMovies else uiState.movies + resultMovies

                currentPage += 1
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = resultMovies.isEmpty(),
                    movies = lastMovies
                )


            }catch (error : Throwable){
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "could not load : ${error.localizedMessage}"
                )

            }


        }

    }




}
