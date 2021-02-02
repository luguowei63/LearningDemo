package com.lgw.android.jetpack.utils

import android.net.ParseException
import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *Created by lgw on 1/28/21
 * 异常处理
 */
object RxExceptionUtil {

    fun exceptionHandler(e: Throwable): String {
        var errorMsg = "未知错误"
        when (e) {
            is UnknownHostException -> errorMsg = "网络不可用"
            is SocketTimeoutException -> errorMsg = "请求网络超时"
            is HttpException -> errorMsg = convertStatusCode(e)
            is ParseException -> errorMsg = "数据解析错误"
            is JSONException -> errorMsg = "数据解析错误"
        }
        return errorMsg
    }


   private  fun convertStatusCode(httpException: HttpException): String {
        var msg = ""
        if (httpException.code() in 500..599) {
            msg = "服务器处理请求出错"
        } else if (httpException.code() in 400..499) {
            msg = "服务器无法处理请求"
        } else if (httpException.code() in 300..399) {
            msg = "请求被重定向到其他页面"
        } else {
            msg = httpException.message()
        }
        return msg
    }


}
