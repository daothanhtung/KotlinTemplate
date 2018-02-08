package com.daoth.kotlinapplication


import com.daoth.kotlinapplication.definition.AppConfiguration
import com.daoth.kotlinapplication.injection.AppComponent
import com.daoth.kotlinapplication.injection.AppModule
import com.daoth.kotlinapplication.injection.DaggerAppComponent
import com.daoth.kotlinapplication.injection.RemoteModule


class KotlinApplication : android.app.Application(){

    override fun onCreate() {
        super.onCreate()
        application = this
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this, AppConfiguration.DATABASE_NAME))
                .remoteModule(RemoteModule(AppConfiguration.BASE_URL))
                .build()
    }

    companion object {
        var appComponent: AppComponent? = null
        var application: KotlinApplication? = null
    }
}
