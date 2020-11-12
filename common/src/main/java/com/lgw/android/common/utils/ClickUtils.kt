package com.lgw.android.common.utils

/**
 *Created by lgw on 2020/11/11
 */

var sLastClickTime: Long = 0

fun canGoClick(): Boolean {
    var currentTime = System.currentTimeMillis()
    if (currentTime - sLastClickTime < 500) {
        return false
    }
    sLastClickTime = currentTime
    return true
}
