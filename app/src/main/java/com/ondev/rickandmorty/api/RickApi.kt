package com.ondev.rickandmorty.api

import com.ondev.rickandmorty.data.PageCharacters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val API_URL = "https://rickandmortyapi.com"

interface RickApi {

    @GET("api/character/")
    suspend fun loadCharacters(@Query("page") page: Int = 0): PageCharacters
}
