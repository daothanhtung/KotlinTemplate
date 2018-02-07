package com.daoth.kotlinapplication.data.remote


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<String>
}
