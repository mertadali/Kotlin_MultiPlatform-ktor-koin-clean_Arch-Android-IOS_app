package com.example.moviekmm.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class AndroidDispatcher  : Dispatcher {  //  normalde tek module ile çalışırken
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

}

internal actual fun provideDispatchers(): Dispatcher = AndroidDispatcher()
