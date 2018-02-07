package com.daoth.kotlinapplication.injection


import com.daoth.kotlinapplication.presentation.main.MainActivity

import dagger.Component
import dagger.Module

@Component(modules = arrayOf(ServiceModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
}
