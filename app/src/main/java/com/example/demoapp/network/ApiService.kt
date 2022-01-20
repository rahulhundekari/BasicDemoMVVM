package com.example.demoapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun call(@Url url: String): Response<ApiResponse>

}