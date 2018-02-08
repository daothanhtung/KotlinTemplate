package com.daoth.kotlinapplication.presentation

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.daoth.kotlinapplication.domain.message.TranslateMessage
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject


open class BaseActivity : AppCompatActivity() {
    @Inject
    open lateinit var eventBus: EventBus



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
        eventBus.register(this)
    }

    override fun onStop() {
        super.onStop()
        eventBus.unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onTranslateMessage(translateMessage: TranslateMessage){
        var intent = Intent(this, translateMessage.target)
        startActivity(intent)
    }
}