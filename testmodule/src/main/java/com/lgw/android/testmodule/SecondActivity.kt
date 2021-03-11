package com.lgw.android.testmodule

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.testmodule.service.LocalService

class SecondActivity : AppCompatActivity() {

    val TAG="SecondActivity"

    lateinit var   bind:TextView
    lateinit var  unBind:TextView
    lateinit var  getData:TextView
     var  localService: LocalService?=null

    /**
     * ServiceConnection 代表与服务链接，它只有两个方法
     * onServiceConnected和onServiceDisconnected
     */
     val conn=object :ServiceConnection{
        /**
         * 与服务器交互的接口方法 绑定服务的时候被回调，在这个方法获取绑定的Sevice
         * 传过来的Ibinder对象
         * 通过这个IBinder 对象，实现宿主和Service的交互
         */
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder= service as LocalService.LocalBinder
            localService=binder.getService()

        }

        override fun onServiceDisconnected(name: ComponentName?) {
              localService=null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //创建绑定对象
        val intent =Intent(this,LocalService::class.java)
        bind=findViewById(R.id.tv_bind)
        bind.setOnClickListener {
            bindService(intent,conn,Service.BIND_AUTO_CREATE)
        }
        unBind=findViewById(R.id.tv_unbind)
        unBind.setOnClickListener {
             //解除绑定
            if (localService!=null){
                localService=null
                unbindService(conn)
            }
        }
        getData=findViewById(R.id.tv_get_data)
        getData.setOnClickListener {
            if (localService != null) {
                // 通过绑定服务传递的Binder对象，获取Service暴露出来的数据

                Log.d(TAG, "从服务端获取数据：" + localService?.getCount());
            } else {

                Log.d(TAG, "还没绑定呢，先绑定,无法从服务端获取数据");
            }

        }
    }






}