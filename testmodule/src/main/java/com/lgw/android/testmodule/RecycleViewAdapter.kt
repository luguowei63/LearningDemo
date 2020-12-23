package com.lgw.android.testmodule

import android.content.Context
import androidx.annotation.NonNull
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.lgw.android.common.utils.L
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
) : BasePullToAdapter<ItemBean>(context, mutableList, layoutResId),LifecycleObserver {
    override fun convert(holder: BaseViewHolder, item: ItemBean) {
    }





    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(@NonNull lifecycleOwner: LifecycleOwner){
        L("RecycleViewAdapter is destroy")
    }


}