package com.example.moviekmm.android.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.moviekmm.domain.usecase.GetMoviesUseCase

class HomeViewModel (val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

}
