package com.lgw.android.coroutine.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 *Created by lgw on 2020/12/9
 */
val okHttpClient=OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()