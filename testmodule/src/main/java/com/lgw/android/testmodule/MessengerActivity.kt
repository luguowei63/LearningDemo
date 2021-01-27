package com.lgw.android.testmodule

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.testmodule.utils.MyConstants


/**
 * 客户端，首先它是一个活动,其次也是需要注册的
 */

class MessengerActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MessengerActivity"

    }

    //用来获取服务端的Messenger,用来给服务端传递消息用的
    lateinit var mService: Messenger

    //这是客户端自己的Messenger,传递给服务端，让服务端返回消息用的
    val mGetReplyMessenger = Messenger(MessengerHandler())

    /**
     * 这个Handler 是用来处理服务端返回的消息的。
     * 这个Handler 将作为一个参数来创建自己的Messenger
     * 然后将这个Messenger传递给服务端，让服务端根据它返回消息
     */

    class MessengerHandler : Handler() {

        override fun handleMessage(msg: Message) {

            when (msg.what) {
                MyConstants.MSG_FROM_SERVICE ->
                    // 处理消息，以Log日志显示出来。
                    Log.e(TAG, "receive msg from Service:" + msg.data.getString("reply"));
                else ->
                    super.handleMessage(msg)
            }


        }
    }


    /**
     * 这个客户端用来绑定服务用的
     * 在绑定过程中会调用onServiceConnected，
     * 它的第二个参数Ibinder service 就是在服务端中 onBinder方法返回的结果。
     * 这个结果是服务端的Messenger对象的Binder对象
     * 然后客户端通过这个BInder对象就可以创建一个Messenger
     * 所以就是在绑定服务的过程中将服务端的Messenger传递给了客户端，建立起了两者之间的桥梁。
     */


    private var mConnectionEvent = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            mService = Messenger(service)
            val msg = Message.obtain(null, MyConstants.MSG_FROM_CLIENT)
            val data = Bundle()
            msg.data = data
            msg.replyTo = mGetReplyMessenger
            try {
                mService.send(msg)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }


        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messenger)

        val intent = Intent("com.lgw.android.testmodule.messenger.MessengerService")
        bindService(intent, mConnectionEvent, Context.BIND_AUTO_CREATE)
    }


    override fun onDestroy() {
        unbindService(mConnectionEvent)
        super.onDestroy()
    }


}