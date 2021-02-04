package com.example.singletonmvvmandcoroutine.api

import com.example.singletonmvvmandcoroutine.Models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts/{id}")
    suspend fun getUser(
        @Path("id") id : String
    ) : User
}