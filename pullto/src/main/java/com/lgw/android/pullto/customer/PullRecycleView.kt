package com.lgw.android.pullto.customer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lgw.android.pullto.R
import com.lgw.android.pullto.adapter.BasePullToAdapter
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.layoutmanager.ILayoutManager


/**
 *Created by lgw on 2020/11/12
 */
class PullRecycleView<T : ItemBean> : FrameLayout, SwipeRefreshLayout.OnRefreshListener,
    BasePullToAdapter.OnLoadMoreListener, BasePullToAdapter.OnEmptyViewClick {

    interface OnRecyclerRefreshListener {
        fun onPullRefresh()
        fun onLoadMore()
    }

    interface OnEmptyViewClick {
        fun onEmptyViewClick()
    }

    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recycleView: RecyclerView

    var onRecyclerRefreshListener: OnRecyclerRefreshListener? = null
        set(value) {
            adapter?.let {
                adapter!!.loadMoreListener = this
            }
            field = value
        }
    private var onEmptyViewClick: OnEmptyViewClick? = null

    var isLoadMoreEnable = true
    var isRefreshEnable = true
    private var adapter: BasePullToAdapter<T>? = null
    private var layoutManager: ILayoutManager? = null

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
        refreshLayout.isEnabled = isRefreshEnable
        recycleView = findViewById(R.id.recycler_view)

        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (checkScrollToBottom() && dy > 0) {
                    checkIfCanLoadMore()
                }
            }
        })
    }


    fun checkScrollToBottom(): Boolean {
        return layoutManager!!.isScrollToBottom(adapter!!.itemCount)
    }

    fun checkIfCanLoadMore() {
        if (isLoadMoreEnable && !adapter!!.isShowLoadMoreFooter) {
            adapter!!.isShowLoadMoreFooter = true
        }

    }

    fun setLayoutManager(layoutManager: ILayoutManager) {
        this.layoutManager = layoutManager
        recycleView.layoutManager = layoutManager.getLayoutManager()
    }

    fun setAdapter(adapter: BasePullToAdapter<T>) {
        adapter.let {
            this.adapter = it
            adapter.enableLoadMore = isLoadMoreEnable
            recycleView.adapter = adapter
        }
    }

    override fun onRefresh() {
        adapter?.isShowLoadMoreFooter = false
        onRecyclerRefreshListener?.onPullRefresh()
    }

    override fun onLoadMore() {
        onRecyclerRefreshListener?.onLoadMore()
    }

    override fun onEmptyViewClick() {
        onEmptyViewClick?.onEmptyViewClick()
    }


    fun finishRefresh() {
        refreshLayout.isRefreshing = false
    }


    fun finishLoadMore() {
        adapter!!.loadMoreFinish()

    }

}


