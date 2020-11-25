package com.lgw.android.pullto.viewholder

import android.view.ViewGroup

/**
 *Created by lgw on 2020/11/18
 */
interface TypeFactory {

    fun createViewHolder(parent: ViewGroup, viewType: Int)

}