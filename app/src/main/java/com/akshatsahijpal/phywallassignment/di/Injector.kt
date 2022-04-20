package com.akshatsahijpal.phywallassignment.di

import com.akshatsahijpal.phywallassignment.api.TeachersApi
import com.akshatsahijpal.phywallassignment.repository.TeachersRepository
import com.akshatsahijpal.phywallassignment.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Injector {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideHomeScreenRepo(api: TeachersApi) = TeachersRepository(api)

    @Provides
    @Singleton
    fun provideNesApi(retro: Retrofit): TeachersApi = retro.create(TeachersApi::class.java)

}