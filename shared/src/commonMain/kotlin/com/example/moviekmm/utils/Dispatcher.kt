package com.example.moviekmm.utils

import kotlinx.coroutines.CoroutineDispatcher

// Threading -> io, main, default   ---    networking -> io thread,  user interface -> main thread
internal interface Dispatcher{
    val io : CoroutineDispatcher
}

internal  expect fun provideDispatchers() : Dispatcher

// expect, actual