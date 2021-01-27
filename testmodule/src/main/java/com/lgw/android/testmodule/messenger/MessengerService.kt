package com.lgw.android.testmodule.messenger

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import com.lgw.android.testmodule.utils.MyConstants

class MessengerService : Service() {

    companion object {
        private const val TAG = "MessengerService"
    }

    /**
     * 继承Handler
     * MessengerHandler 用来处理客户端发送的消息
     * 并从消息中取出客户端发来的文本信息
     */

    class MessengerHandler : Handler() {

        override fun handleMessage(msg: Message) {

            when (msg.what) {
                MyConstants.MSG_FROM_CLIENT -> {
                    Log.e(TAG, "receive msg from Client ${msg.data.getString("msg")}")
                    /**
                     * 这下面的语句是用来响应客户端的，给客户端回馈消息的
                     * （1）第一步是通过replyto来获取客户端的Messenger对象
                     *  （2）是创建一个Message消息，
                     *  Message.obatin这个这个方法的第一个参数是Handler，第二个参数是消息的what字段
                     *  （3）创建一个Bundle对象，然后向这个对象中添加String内容
                     *  （4）将Bundle对象设置给Message
                     *   （5）通过MEssenger 将Message发送出去
                     *
                     *  因为我们的messenger 是通过客户端来获取的，而在客户端那边，这个Messenger是以Handle为参数创建的
                     *  所以在服务端通过客户端的Messenger发送消息后，在客户端的Handler 就会处理这条消息，
                     *
                     */
                    val client = msg.replyTo
                    val replyMessage = Message.obtain(null, MyConstants.MSG_FROM_SERVICE)
                    val bundle = Bundle()
                    bundle.putString("reply", "嗯，你的消息我已经收到，稍后会回复你。");
                    replyMessage.data = bundle
                    try {
                        client.send(replyMessage)
                    } catch (e: RemoteException) {
                        e.printStackTrace()
                    }
                }
                else ->
                    super.handleMessage(msg)
            }
        }
    }


    /**
     * 这是服务端的Messenger,它是以上面的Handler 对象为参数创建的，
     * 这个Messenger 是要通过绑定该服务器的时候onBind方法传递给客户端
     * 然后客户端获取了该Messenger，再以该Messenger来发送消息。
     * 这样服务就可以接收并处理该消息了
     */


    var mMessenger = Messenger(MessengerHandler())

    /**
     * 这个方法是在绑定服务的过程中调用的并将结果返回给客户端
     * 所以通过onBind方法客户端就可以获取我们Messenger的Binder对象了，
     * 然后可不断就可以根据BInder对象来创建一个Messanegerle
     *
     */
    override fun onBind(intent: Intent): IBinder {
        return mMessenger.binder
    }
}