package ru.stas.movieapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.stas.movieapp.data.models.Movies

interface ApiService {

    @GET("/shows")
    suspend fun getAllMovies(): Response<List<Movies>>
}