package com.lgw.android.coroutine.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


/**
 *Created by lgw on 2020/12/9
 */

data class GitUser(val id: String, val name: String, val url: String)


val gitHubServiceApi: GitHubServiceApi by lazy {
    val retrofit = retrofit2.Retrofit.Builder().client(
        OkHttpClient.Builder().addInterceptor(Interceptor { it.proceed(it.request()).apply { } })
            .build())
        .baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    retrofit.create(GitHubServiceApi::class.java)
}


interface GitHubServiceApi {
    @GET("users/{login}")
    fun getUserCallback(@Path("login") login: String): Call<GitUser>

    @GET("users/{login}")
    suspend fun getUserSuspend(@Path("login") login: String): GitUser


}





























