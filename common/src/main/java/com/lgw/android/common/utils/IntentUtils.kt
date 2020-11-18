package com.lgw.android.common.utils

import android.content.Context
import android.content.Intent

/**
 *Created by lgw on 2020/11/18
 */


inline fun <reified T> forward(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}


inline fun <reified T> forward(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}
