package com.jinxtris.ram.headapp.retrofit

import com.jinxtris.ram.headapp.model.Root
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/json")
    fun categoryData(): Call<Root>?
}