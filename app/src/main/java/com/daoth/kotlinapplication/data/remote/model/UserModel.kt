package com.daoth.kotlinapplication.data.remote.model


import com.google.gson.annotations.SerializedName

class UserModel {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null

    constructor() {}

    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }
}
