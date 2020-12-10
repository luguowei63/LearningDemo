package com.lgw.android.coroutine

import android.app.Application
import android.content.Context
import com.lgw.android.coroutine.exception.GlobalThreadUncaughtExceptionHandler
import timber.log.Timber

/**
 *Created by lgw on 2020/12/9
 */

lateinit var appContext: Application
class App :Application(){
    override fun onCreate() {
        super.onCreate()
        appContext=this
        Timber.plant(Timber.DebugTree())
        GlobalThreadUncaughtExceptionHandler.setUp()

    }
}
