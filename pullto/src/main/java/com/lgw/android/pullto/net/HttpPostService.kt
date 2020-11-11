package com.lgw.android.pullto.net

import com.lgw.android.common.http.base.BaseResponse
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.utils.UrlConstant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


/**
 *Created by lgw on 2020/11/10
 */
interface HttpPostService {


    @POST(UrlConstant.listUrlSuffix)
    fun getData(): Call<BaseResponse<ItemBean>>




}