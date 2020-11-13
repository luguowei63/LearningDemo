package com.lgw.android.common.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.lang.Error

/**
 *Created by lgw on 2020/11/12
 * 使用建造者模式将Glide进行重新整理。
 */

/**
 * 加载网络图片
 */
fun loadImgFromInternet(context: Context, imgUrl:String,holder:Int,error: Int,fallBack:Int,options:RequestOptions,imageView: ImageView){
    Glide.with(context).load(imgUrl).placeholder(holder).error(error).fallback(fallBack).apply(options).into(imageView)
}

/**
 * 设置图片
 */
