package com.lgw.android.pullto.layoutmanager

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by lgw on 2020/11/12
 */
interface ILayoutManager {
    /**
     * 获取当前显示的第一Item的位置
     */
    fun getFirstVisibleItem():Int

    /**
     * 获取最后一个显示的Item的位置
     */
    fun getLastVisibleItem():Int

    /**
     * 获取当前设置的Manager
     */

    fun getLayoutManager(): RecyclerView.LayoutManager

    /**
     * 设置当前的Manager
     */

    fun setLayoutManager(  recyclerView: RecyclerView? )


    fun isScrollToBottom():Boolean

}