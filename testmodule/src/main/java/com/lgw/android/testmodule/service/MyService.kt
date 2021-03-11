package com.lgw.android.testmodule.service

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    val code =1
    val TAG="IPC"
    /**
     * 创建一个送信人
     */
    private   val mMessenger =Messenger(object :Handler(){
        override fun handleMessage(msg: Message) {
            Log.e(TAG,"handleMessage")
            var toClient=Message.obtain()
            when(msg.what){
                code->{
                    //接收来自客户端的消息，并做处理
                    var arg=msg.arg1
                    Toast.makeText(applicationContext,arg , Toast.LENGTH_SHORT).show()
                    toClient.arg1 = 1111111111
                    try {
                        //回复客户端消息
                        msg.replyTo.send(toClient)
                    }catch ( e:RemoteException){
                        e.printStackTrace()
                    }
                }
            }
            super.handleMessage(msg)
        }
    })


    override fun onBind(intent: Intent?): IBinder? {
        return mMessenger.binder
    }


}