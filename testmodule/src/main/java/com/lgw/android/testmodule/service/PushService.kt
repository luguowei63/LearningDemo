package com.lgw.android.testmodule.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.lgw.android.testmodule.aidl.MyServer

class PushService : Service() {
    private val myServer = MyServer()
    override fun onBind(intent: Intent): IBinder {
        return myServer
    }
}