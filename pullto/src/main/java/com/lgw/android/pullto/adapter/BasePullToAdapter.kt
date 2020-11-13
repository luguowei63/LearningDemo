package com.lgw.android.pullto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lgw.android.pullto.viewholder.BaseViewHolder

/**
 *Created by lgw on 2020/11/12
 */
abstract class BasePullToAdapter<T>(context: Context, mutableList: MutableList<T>, layoutResId: Int) : BaseViewAdapter<T>(context,mutableList,layoutResId) {


}