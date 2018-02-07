package com.daoth.kotlinapplication.injection


import com.daoth.kotlinapplication.data.remote.ApiInterface
import com.daoth.kotlinapplication.definition.ApiConfiguration

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServiceModule {
    @Provides
    fun provideApiInterface(): ApiInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConfiguration.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
        return retrofit.create(ApiInterface::class.java)
    }
}
