package com.daoth.kotlinapplication.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
class User {
    @NonNull
    @PrimaryKey
    var id: String? = null

    @ColumnInfo
    var name: String? = null
}
