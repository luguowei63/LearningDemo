package com.lgw.android.testmodule.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    /**
     * 绑定服务时才会调用
     * 必须要实现的方法
     */
    override fun onBind(intent: Intent): IBinder? {
        return  null
    }


    /**
     * 首次创建服务时，系统调用此方法执行一次性设置程序（在调用 onStartCommand()或onBind() 之前）
     * 如果服务已在运行，则不会调用此方法，该方法只会被调用一次
     */
    override fun onCreate() {
        super.onCreate()
    }

    /**
     * 每次通过StartService() 方法启动Service时都会被回调
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * 服务销毁时的回调
     */
    override fun onDestroy() {
        super.onDestroy()
    }





}