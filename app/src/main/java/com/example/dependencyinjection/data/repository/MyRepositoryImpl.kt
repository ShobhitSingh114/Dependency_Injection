package com.example.dependencyinjection.data.repository

import android.app.Application
import com.example.dependencyinjection.R
import com.example.dependencyinjection.data.remote.MyApi
import com.example.dependencyinjection.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository{

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }
    override suspend fun doNetworkCall() {

    }
}