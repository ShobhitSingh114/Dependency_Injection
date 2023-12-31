package com.example.dependencyinjection.di

import com.example.dependencyinjection.data.remote.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

//singletonComponent means dependency lives as ling as whole application does
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton //instance of this make one time and last as app does
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

}