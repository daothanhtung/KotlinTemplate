package com.daoth.kotlinapplication.data.database


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.daoth.kotlinapplication.data.database.dao.UserDao
import com.daoth.kotlinapplication.data.database.entity.User

@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
