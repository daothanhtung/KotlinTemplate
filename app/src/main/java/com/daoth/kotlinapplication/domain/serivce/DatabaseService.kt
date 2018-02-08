package com.daoth.kotlinapplication.domain.serivce


import com.daoth.kotlinapplication.data.database.AppDatabase
import com.daoth.kotlinapplication.data.database.entity.User
import com.daoth.kotlinapplication.data.remote.ApiInterface

import javax.inject.Inject

import io.reactivex.Single

class DatabaseService @Inject
constructor(private val db: AppDatabase, private val api: ApiInterface) {

    fun allUsers(): Single<List<User>> {
        return Single.create { emitter ->
            try {
                val userList = db.userDao().all()
                emitter.onSuccess(userList)
            } catch (exception: Exception) {
                emitter.onError(exception)
            }
        }
    }
}
