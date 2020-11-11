package com.lgw.android.common

import android.app.Application
import android.content.res.Configuration

/**
 *Created by lgw on 2020/11/11
 */
abstract class CommonAppInit {

    var mApplication: Application? = null

     open fun onCreate() {}

     open fun onTerminate() {}

     open fun onLowMemory() {}

     open fun configurationChanged(configuration: Configuration) {}


}