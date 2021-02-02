package com.lgw.android.aidl_server

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 *Created by lgw on 1/27/21
 */
class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        return  MyBinder()
    }


    class MyBinder : IMyAidlInterface.Stub() {
        override fun getValue(): String {

           return "Hello World AIDL "
        }

    }



}