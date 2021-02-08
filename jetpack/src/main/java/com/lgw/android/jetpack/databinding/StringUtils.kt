package com.lgw.android.jetpack.databinding

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

/**
 *Created by lgw on 2/8/21
 */
object StringUtils {


    fun  toUpperCase(str: String):String{
        return str.toUpperCase(Locale.ROOT)
    }

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: TextView, text:CharSequence){
        Log.e("TAG","11111111")
        val txt = text.toString().toLowerCase(Locale.ROOT)
        view.text=txt
    }

}