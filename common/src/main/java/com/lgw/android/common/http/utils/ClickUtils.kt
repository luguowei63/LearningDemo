package com.lgw.android.common.http.utils

/**
 *Created by lgw on 2020/11/11
 */
object ClickUtils {

    var sLastClickTime: Long = 0

    fun canClick(): Boolean {
        var currentTime = System.currentTimeMillis()
        if (currentTime - sLastClickTime < 500) {
            return false
        }
        sLastClickTime = currentTime
        return true
    }

}