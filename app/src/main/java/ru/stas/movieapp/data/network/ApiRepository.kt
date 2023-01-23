package ru.stas.movieapp.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllMovie() = apiService.getAllMovies()
}