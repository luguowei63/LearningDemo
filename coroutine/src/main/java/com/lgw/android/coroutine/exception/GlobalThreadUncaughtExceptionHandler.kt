package com.lgw.android.coroutine.exception

import timber.log.Timber

/**
 *Created by lgw on 2020/12/9
 */
class GlobalThreadUncaughtExceptionHandler :Thread.UncaughtExceptionHandler{
    companion object{
        fun setUp(){
            Thread.setDefaultUncaughtExceptionHandler(GlobalThreadUncaughtExceptionHandler())
        }
    }

    //Do not use lazy here

    private  val defaultUncaughtExceptionHandler=Thread.getDefaultUncaughtExceptionHandler()


    override fun uncaughtException(t: Thread, e: Throwable) {
        Timber.d(e, "Uncaugth exception in thread: ${t.name}")
        defaultUncaughtExceptionHandler?.uncaughtException(t,e)


    }
}