package com.daoth.kotlinapplication.injection

import android.arch.persistence.room.Room
import android.util.Log
import com.daoth.kotlinapplication.KotlinApplication
import com.daoth.kotlinapplication.data.database.AppDatabase

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus


@Module
class AppModule(val application: KotlinApplication, val dabaseName: String) {

    @Provides
    @Singleton
    fun providesApplication(): KotlinApplication {
        Log.d("injection", "providesApplication")
        return application
    }

    @Singleton
    @Provides
    fun provideDatabase(application: KotlinApplication): AppDatabase {
        Log.d("injection", "provideDatabase")
        return Room.databaseBuilder(application, AppDatabase::class.java, dabaseName).build();
    }

    @Singleton
    @Provides
    fun provideBus(): EventBus {
        Log.d("injection", "provideBus")
        return EventBus.getDefault()
    }
}
