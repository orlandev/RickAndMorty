package com.ondev.rickandmorty.di

import com.ondev.rickandmorty.api.API_URL
import com.ondev.rickandmorty.data.PageCharacters
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModulesDI {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(moshiConverterFactory)
        .build()
}