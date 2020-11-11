package com.lgw.android.pullto

import android.content.res.Configuration
import android.util.Log
import com.lgw.android.common.CommonAppInit

/**
 *Created by lgw on 2020/11/11
 */
class PullApplication : CommonAppInit() {
    val TAG: String = PullApplication::class.java.simpleName

    override fun onCreate() {
        Log.i(TAG, "ModuleThreeAppInit---onCreate");

    }

    override fun onTerminate() {}

    override fun onLowMemory() {}

    override fun configurationChanged(configuration: Configuration) {}


}