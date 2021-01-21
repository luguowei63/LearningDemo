package com.lgw.android.apt_library

import android.app.Activity
import android.util.Log

/**
 *Created by lgw on 1/20/21
 */
object BindViewFactory {


    fun inject(activity: Activity){
        val clazz=activity::class.java
        val bindViewClass=Class.forName(clazz.simpleName+"_ViewBinding")
        Log.e("TAG","bindViewClass   "+bindViewClass.simpleName.toString())
        val method=bindViewClass.getMethod("bind",clazz)
        Log.e("TAG", "bindViewClass   $method")

        method.invoke(bindViewClass.newInstance(),activity)

    }


}