package com.lgw.android.testmodule.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log

class MessengerService : Service() {

    val MSG_SAY_HELLO = 1;
    val TAG = "MessengerService"


    /**
     * 用于接收从客户端传递过来的数据
     */

    inner class IncomingHandler : Handler() {

        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_SAY_HELLO -> {
                    Log.e(TAG, "thanks,Service had receiver message from client!");
                }
                else -> {
                    super.handleMessage(msg)
                }
            }
        }
    }

    /**
     * 创建Messenger 并传入Handler
     */
     val  mMessage =Messenger(IncomingHandler())



    override fun onBind(intent: Intent): IBinder? {
        return mMessage.binder
    }
}