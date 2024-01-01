package com.example.dependencyinjection.di

import android.app.Application
import com.example.dependencyinjection.data.remote.MyApi
import com.example.dependencyinjection.data.repository.MyRepositoryImpl
import com.example.dependencyinjection.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
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

    @Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi,
        app: Application,
        @Named("hello1") hello1: String
    ): MyRepository {
        return MyRepositoryImpl(api, app)
    }

    /**
     * Two dependencies of same type
     */

    @Provides
    @Singleton
    @Named("hello1")
    fun prividesString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun proviesString2() = "Hello 2"

}
