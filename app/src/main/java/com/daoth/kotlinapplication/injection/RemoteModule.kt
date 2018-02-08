package com.daoth.kotlinapplication.injection


import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.daoth.kotlinapplication.KotlinApplication
import com.daoth.kotlinapplication.data.remote.ApiInterface
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RemoteModule(val baseUrl: String) {

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        Log.d("injection", "provideApiInterface")
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(application: KotlinApplication):SharedPreferences {
        Log.d("injection", "providesSharedPreferences")
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: KotlinApplication): Cache {
        Log.d("injection", "provideOkHttpCache")
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        Log.d("injection", "provideGson")
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        Log.d("injection", "provideOkHttpClient")
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        Log.d("injection", "provideRetrofit")
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }
}
