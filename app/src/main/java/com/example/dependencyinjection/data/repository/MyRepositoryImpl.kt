package com.example.dependencyinjection.data.repository

import com.example.dependencyinjection.data.remote.MyApi
import com.example.dependencyinjection.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi
) : MyRepository{
    override suspend fun doNetworkCall() {

    }
}