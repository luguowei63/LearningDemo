package com.lgw.android.learn

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 同一个服务只会开启一个工作线程
         * 在onHandleIntent()函数里。依次处理传入的Intent请求
         * 将请求通过Bundle对象传入到Intent，在传入到服务里
         */
        //请求1
        val intent=Intent()

        val bundle=Bundle()
        bundle.putString("taskName","task1")

        intent.setPackage("com.lgw.android.testmodule.service.MyIntentService");
        intent.putExtras(bundle)
        startService(intent)

//        //请求2
//        val intent2=Intent("MyIntentService")
//        val bundle2=Bundle()
//        bundle2.putString("taskName","task2")
//        intent2.putExtras(bundle2)
//        startService(intent2)








    }



}