package com.lgw.android.common.utils

import android.util.Log

/**
 *Created by lgw on 2020/11/12
 */
 val TAG: String = "------>"

fun L(msg: String) {
    L(TAG, msg)

}

/**
 * 截断输出日志
 *
 * @param msg
 */
fun L(tag: String?, msg: String?) {
    var msg = msg
    if (tag == null || tag.length == 0 || msg == null || msg.length == 0) return
    val segmentSize = 3 * 1024
    val length = msg.length.toLong()
    // 长度小于等于限制直接打印
    if (length <= segmentSize) {
        Log.e(tag, msg)
    } else {
        // 循环分段打印日志
        while (msg!!.length > segmentSize) {
            val logContent = msg.substring(0, segmentSize)
            msg = msg.replace(logContent, "")
            Log.e(tag, logContent)
        }
        // 打印剩余日志
        Log.e(tag, msg)
    }
}