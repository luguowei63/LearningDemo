package com.lgw.android.coroutine.api

import okhttp3.Response
import java.io.IOException


/**
 *Created by lgw on 2020/12/9
 */
class HttpException (private val response: Response):IOException(response.toString())