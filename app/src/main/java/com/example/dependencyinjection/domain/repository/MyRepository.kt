package com.example.dependencyinjection.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}