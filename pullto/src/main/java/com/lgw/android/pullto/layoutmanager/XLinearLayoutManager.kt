package com.lgw.android.pullto.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lgw.android.common.utils.L

/**
 *Created by lgw on 2020/11/12
 */
class XLinearLayoutManager : LinearLayoutManager, ILayoutManager {
    constructor(context: Context) : this(context, RecyclerView.VERTICAL, false)

    constructor(context: Context, orientation: Int, reverseLayout: Boolean) : super(
        context,
        orientation,
        reverseLayout
    )

    override fun getFirstVisibleItem(): Int {
        return this.findFirstVisibleItemPosition()
    }

    override fun getLastVisibleItem(): Int {
        return this.findLastVisibleItemPosition()
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return this
    }

    override fun setLayoutManager(recyclerView: RecyclerView?) {
        recyclerView?.let { recyclerView.layoutManager = this }

    }

    override fun isScrollToBottom(itemCount:Int): Boolean {
        L("last   "+this.findLastVisibleItemPosition())
        L("count  $itemCount")
        return this.findLastVisibleItemPosition()==itemCount-1
    }

}