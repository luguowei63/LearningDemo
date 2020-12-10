package com.lgw.android.jetpack.common

import android.app.Application
import android.content.Context

/**
 *Created by lgw on 2020/12/10
 */
class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        context=this
    }

    companion object{
        lateinit var context: Context
    }


}