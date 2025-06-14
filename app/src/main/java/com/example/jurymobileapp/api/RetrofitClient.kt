package com.example.jurymobileapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.Moshi



object RetrofitClient {

    private const val BASE_URL = "http://192.168.100.26/Konkurs/"

    private val moshi = Moshi.Builder().build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }


}