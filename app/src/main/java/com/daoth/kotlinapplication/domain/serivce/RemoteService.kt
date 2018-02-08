package com.daoth.kotlinapplication.domain.serivce


import com.daoth.kotlinapplication.data.remote.ApiInterface

import javax.inject.Inject

class RemoteService @Inject
constructor(private val api: ApiInterface)
