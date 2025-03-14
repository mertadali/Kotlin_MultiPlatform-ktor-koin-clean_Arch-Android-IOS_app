package com.example.moviekmm.utils

import com.example.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}