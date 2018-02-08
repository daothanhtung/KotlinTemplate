package com.daoth.kotlinapplication.injection


import com.daoth.kotlinapplication.presentation.main.MainActivity
import com.daoth.kotlinapplication.presentation.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RemoteModule::class, AppModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)
}
