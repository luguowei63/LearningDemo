package com.lgw.android.learn

import android.app.ActivityManager
import android.content.Context
import android.os.Debug
import android.util.Log
import com.lgw.android.common.CommonApplication
import com.lgw.android.pullto.PullApplication
import com.squareup.leakcanary.LeakCanary

/**
 *Created by lgw on 2020/11/11
 */
class AppContext : CommonApplication() {

    private val TAG = "lgw"
    override fun appInit() {
        registerApplication(PullApplication::class.java)
        //获取当前正在运行的进程的UID
        val pid = android.os.Process.myPid()
        Log.d(TAG, "MyApplication onCreate")
        Log.d(TAG, "MyApplication pid is $pid")

        val am=getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager


//        val runningApps=am.runningAppProcesses
//        if (runningApps!=null&& runningApps.isNotEmpty()){
//            for ( prcInfo)
//        }
        if(LeakCanary.isInAnalyzerProcess(this)){
            return
        }
        LeakCanary.install(this)




    }
}