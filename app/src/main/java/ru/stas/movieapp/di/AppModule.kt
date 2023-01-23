package ru.stas.movieapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.stas.movieapp.data.network.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    private const val BASE_URL = "https://api.tvmaze.com/"

    @Provides
    @Singleton
    fun providerRetrofit(): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}