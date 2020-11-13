package com.lgw.android.pullto.customer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lgw.android.pullto.R
import com.lgw.android.pullto.adapter.BaseViewAdapter
import com.lgw.android.pullto.layoutmanager.ILayoutManager


/**
 *Created by lgw on 2020/11/12
 */
class PullRecycleView : FrameLayout, SwipeRefreshLayout.OnRefreshListener {

    interface OnRecyclerRefreshListener {

        fun onRefresh()

        fun onLoadMore()
    }


    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recycleView: RecyclerView

    var onRecyclerRefreshListener: OnRecyclerRefreshListener? = null
    private lateinit var layoutManager: ILayoutManager
    private lateinit var adapter: BaseViewAdapter

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.pullto_layout_recycler, this, true)
        refreshLayout = findViewById(R.id.swipe_refresh_widget)
        refreshLayout.setOnRefreshListener(this)
        recycleView = findViewById(R.id.recycler_view)
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (checkScrollToBottom()&&dy > 0) {
                    checkIfCanLoadMore()
                }
            }
        })
    }









    fun checkScrollToBottom(): Boolean {
        return layoutManager.isScrollToBottom(adapter.itemCount)
    }

    fun checkIfCanLoadMore() {
        //todo 判断是否能够上拉加载数据
    }


    override fun onRefresh() {
        onRecyclerRefreshListener?.apply { this.onRefresh() }
    }


}


