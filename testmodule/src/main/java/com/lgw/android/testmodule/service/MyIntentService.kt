package com.lgw.android.testmodule.service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    private  val TAG="MyIntentService"

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG,"onCreate   "+Thread.currentThread().name)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG,"onStartCommand     "+Thread.currentThread().name)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
            Log.e(TAG,"onHandleIntent   "+Thread.currentThread().name)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy()   "+Thread.currentThread().name)
    }


}