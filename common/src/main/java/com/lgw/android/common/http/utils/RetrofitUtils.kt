package com.lgw.android.common.http.utils

import Constants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *Created by lgw on 2020/11/10
 */
class RetrofitUtils {


    companion object {
        /**
         * 定义超时时间
         */
        private const val DEFAULT_TIME_OUT: Long = 10 * 1000
        private var retrofit: Retrofit? = null
            @Synchronized
            get() {
                if (field == null) {
                    val logIntercept = HttpLoggingInterceptor();
                    val builder: OkHttpClient.Builder =
                        OkHttpClient.Builder().addInterceptor(logIntercept)
                    builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
                    retrofit = Retrofit.Builder().client(builder.build())
                        .addConverterFactory(GsonConverterFactory.create())
//                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(Constants.baseUrl)
                        .build()
                }
                return field
            }

        /**
         * 强行使用一次lazy函数
         */
//        val initRetrofitByLazy by lazy{
//            retrofit
//        }

        fun getRetrofitInstance():Retrofit{
            return retrofit!!
        }



    }

}