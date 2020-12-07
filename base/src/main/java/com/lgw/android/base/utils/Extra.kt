package com.lgw.android.base.utils

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.view.View

/**
 *Created by lgw on 2020/12/3
 * 扩展函数,高阶函数定义类
 */

var clickTime = 0L
fun View.canClick(): Boolean {
    val currentTime = System.currentTimeMillis()
    if (currentTime - clickTime > 500) {
        clickTime = currentTime
        return true
    }

    return false
}


inline fun StringBuilder.build(block: StringBuilder.() -> StringBuilder): StringBuilder {
    append(block().toString())
    return this
}


fun StringBuilder.build(str: String): java.lang.StringBuilder {
    append(str)
    return this
}


inline fun SharedPreferences.save(block: SharedPreferences.Editor.() -> Unit) {
    @SuppressLint("CommitPrefEdits")
    val edit = edit()
    edit.block()
    edit().apply()
}











