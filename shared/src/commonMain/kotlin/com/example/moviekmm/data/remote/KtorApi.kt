package com.example.moviekmm.data.remote

import com.example.moviekmm.utils.Constants.API_KEY
import com.example.moviekmm.utils.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


internal abstract class KtorApi {
    val client = HttpClient {
       install(ContentNegotiation){             // used content negotiation  for converting json
           json(Json {
               ignoreUnknownKeys = true
               useAlternativeNames = false  // ->  blocking Conflict
           })
       }
    }

    fun HttpRequestBuilder.pathUrl(path : String){
        url{
            takeFrom(BASE_URL)
            path("3")        // constant parameter
            parameter("api_key", API_KEY)

        }
    }

}

