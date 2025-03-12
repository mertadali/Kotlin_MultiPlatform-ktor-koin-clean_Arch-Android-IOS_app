package com.example.moviekmm.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class AndroidDispatcher  : Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

}

internal actual fun provideDispatchers(): Dispatcher = AndroidDispatcher()
