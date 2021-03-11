package com.lgw.android.testmodule

import android.annotation.SuppressLint
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


/**
 * 客户端，首先它是一个活动,其次也是需要注册的
 */

class MessengerActivity : AppCompatActivity() {
    val TAG="IPC"
    var mBond = false
    var serviceMessenger: Messenger? = null
    var connection: MyConn? = null

    val mMessenger =Messenger(object :Handler(){

        override fun handleMessage(msg: Message) {
            Toast.makeText(applicationContext,msg.arg1,Toast.LENGTH_SHORT).show();
        }

    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messenger)
        //绑定服务
        val intent = Intent()
        intent.action = "com.lgw.android.testmodule.service.MyService"
        intent.`package`="com.lgw.android.testmodule"
        connection=MyConn()
        bindService(intent,connection!!,Service.BIND_AUTO_CREATE)


        findViewById<Button>(R.id.btn).setOnClickListener {
            val clientMessage = Message.obtain()
            clientMessage.what = 1
            clientMessage.arg1 = 12345
            try {
                clientMessage.replyTo = mMessenger
                serviceMessenger?.send(clientMessage);
            } catch (e: RemoteException) {
                e.printStackTrace()
            }

        }
    }


    inner class MyConn : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            //连接成功
            serviceMessenger= Messenger(service)
            Log.e(TAG,"服务连接成功")
            mBond=true

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            serviceMessenger=null
            mBond=false
        }
    }




    override fun onDestroy() {
        if (mBond){
            connection?.let { unbindService(it) }
        }
        super.onDestroy()
    }




}