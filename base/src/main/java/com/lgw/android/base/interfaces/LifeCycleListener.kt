package com.lgw.android.base.interfaces

/**
 *Created by lgw on 2020/11/11
 */
interface LifeCycleListener {

    fun onCreate()

    fun onStart()

    fun onRestart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()

}