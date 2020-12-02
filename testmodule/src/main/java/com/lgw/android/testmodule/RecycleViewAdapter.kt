package com.lgw.android.testmodule

import android.content.Context
import com.lgw.android.pullto.adapter.BasePullToAdapter
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.viewholder.BaseViewHolder

/**
 *Created by lgw on 2020/11/27
 */
class RecycleViewAdapter(
    context: Context,
    mutableList: MutableList<ItemBean>,
    layoutResId: Int
) : BasePullToAdapter<ItemBean>(context, mutableList, layoutResId) {
    override fun convert(holder: BaseViewHolder, item: ItemBean) {
    }
}