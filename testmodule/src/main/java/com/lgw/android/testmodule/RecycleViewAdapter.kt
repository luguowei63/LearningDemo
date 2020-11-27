package com.lgw.android.testmodule

import android.content.Context
import com.lgw.android.pullto.adapter.BasePullToAdapter
import com.lgw.android.pullto.viewholder.BaseViewHolder

/**
 *Created by lgw on 2020/11/27
 */
class RecycleViewAdapter<T>(
    context: Context,
    mutableList: MutableList<T>,
    layoutResId: Int
) : BasePullToAdapter<T>(context, mutableList, layoutResId) {
    override fun convert(holder: BaseViewHolder, item: T) {

    }
}