package com.lgw.android.common.http.utils

import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 *Created by lgw on 2020/11/10
 */
object RxExceptionUtil {
    fun exceptionHandler(e: Throwable): String {
        var errorMsg = "未知错误"
        e.let {
            errorMsg = when (it) {
                is UnknownHostException -> "网络不可用"
                is SocketTimeoutException -> "请求网络超时"
                is HttpException -> convertStatusCode(it)
                is ParseException -> "数据解析错误"
                is JSONException -> "数据解析错误"
                else -> "请求网络超时"
            }
        }
        return errorMsg
    }


    private fun convertStatusCode(httpException: HttpException): String {

        var msg = ""
        msg = when (httpException.code()) {
            in 500..599 -> "服务器处理请求出错"
            in 400 until 500 -> "服务器无法处理请求"
            in 300 until 400 -> "请求被重定向到其他页面"
            else -> httpException.message()
        }
        return msg
    }


}