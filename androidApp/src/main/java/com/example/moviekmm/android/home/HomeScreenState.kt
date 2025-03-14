package com.example.moviekmm.android.home

import com.example.moviekmm.domain.model.Movie

data class HomeScreenState(
    var loading : Boolean = false,
    var refreshing : Boolean = false,
    var loadFinished : Boolean = false,
    var errorMessage : String? = null,
    var movies : List<Movie> = listOf()
)
