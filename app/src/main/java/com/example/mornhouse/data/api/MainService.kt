package com.example.mornhouse.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {

    @GET("{number}")
    suspend fun getNumberDescription(@Path("number") number: String): Response<String>

    @GET("/random/math")
    suspend fun getRandomNumberDescription(): Response<String>

    companion object{
        const val BASE_URL = "http://numbersapi.com"
    }

}