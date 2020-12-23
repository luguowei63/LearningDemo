package com.lgw.android.common.utils

import android.app.Activity
import android.util.DisplayMetrics

/**
 *Created by lgw on 2020/12/23
 */

/**
 * 获取屏幕宽度
 */
fun getScreenWidth(activity: Activity): Int {
    var displayMetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

/**
 * 获取屏幕高度
 */
fun getScreenHeight(activity: Activity): Int {
    var displayMetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics.heightPixels
}