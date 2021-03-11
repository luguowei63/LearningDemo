package com.lgw.android.testmodule.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class LocalService : Service() {


    private  val TAG="LocalService"
    private  var count=0
    private  var quit=false
    private lateinit var thread: Thread
    private  var binder=LocalBinder()


    /**
     * 创建Binder 对象，返回给客户端即Activity使用，提供数据交换的接口
     */

   inner class LocalBinder : Binder() {

        //声明一个方法，getService。（提供给客户端使用）
        fun getService():LocalService{
            //返回当前对象LocalService，这样我们就可在客户端调用Service的公共方法了
            return this@LocalService

        }

    }




    override fun onBind(intent: Intent): IBinder {
        Log.e(TAG, "Service is invoke onBind" )
        return binder
    }


    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "Service is invoke onCreate" )
        thread=Thread{
            //每间隔一秒count +1 直到quit 为true
            while (!quit){
                try {

                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
                count++
                Log.e(TAG, "Service  +$count")
            }
        }
        thread.start()



    }


    /**
     * 公共方法
     */
    fun  getCount():Int{
        return  count
    }

    /**
     * 解除绑定时调用
     */
    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG, "Service is invoke onUnbind");
        return super.onUnbind(intent)
    }


    override fun onDestroy() {
        Log.e(TAG, "Service is invoke Destroyed")
        quit = true
        super.onDestroy()
    }


}