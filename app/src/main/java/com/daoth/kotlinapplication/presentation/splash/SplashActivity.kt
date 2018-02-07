package com.daoth.kotlinapplication.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.daoth.kotlinapplication.R
import com.daoth.kotlinapplication.presentation.BaseActivity
import com.daoth.kotlinapplication.presentation.main.MainActivity

class SplashActivity : BaseActivity() {
    val handler : Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed({ startActivity(Intent(this, MainActivity::class.java)) }, 2000)
    }
}
