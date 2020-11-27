package com.lgw.android.pullto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lgw.android.pullto.R
import com.lgw.android.pullto.viewholder.BaseViewHolder

/**
 *Created by lgw on 2020/11/12
 */
open abstract class BasePullToAdapter<T>(
    context: Context,
    mutableList: MutableList<T>,
    layoutResId: Int
) :
    BaseViewAdapter<T>(context, mutableList, layoutResId) {

    interface OnLoadMoreListener {
        fun onLoadMore()
    }

    interface OnEmptyViewClick {
        fun onEmptyViewClick()
    }

    var enableLoadMore = true
    var isShowLoadMoreFooter = false
    var isShowLoadDone = false
    var mEmptyEnable = false
    var emptyViewClick=true


    var loadMoreListener: OnLoadMoreListener? = null
    var onEmptyViewClick: OnEmptyViewClick? = null

    companion object {
        const val VIEW_TYPE_LOAD_MORE = 100
        const val VIEW_TYPE_LOAD_DONE = 101
        const val VIEW_TYPE_EMPTY_VIEW = 102
        const val VIEW_TYPE_ITEM = 103
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var viewHolder: BaseViewHolder

        when (viewType) {
            VIEW_TYPE_LOAD_MORE -> {
                val footView = LayoutInflater.from(mContext)
                    .inflate(R.layout.pullto_item_footer, parent, false);
                viewHolder = BaseViewHolder(footView)
            }

            VIEW_TYPE_LOAD_DONE -> {
                val footView = LayoutInflater.from(mContext)
                    .inflate(R.layout.pullto_item_load_done, parent, false);
                viewHolder = BaseViewHolder(footView)
                viewHolder.setVisibility(R.id.pb_bar, View.GONE)
            }
            VIEW_TYPE_EMPTY_VIEW -> {
                val footView = LayoutInflater.from(mContext)
                    .inflate(R.layout.pullto_empty_view, parent, false);
                viewHolder = BaseViewHolder(footView)
            }
            else -> {
                viewHolder = super.onCreateViewHolder(parent, viewType)
            }
        }
        return viewHolder
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_LOAD_MORE -> {
                loadMoreListener?.onLoadMore()
            }
            VIEW_TYPE_EMPTY_VIEW -> {
                if (emptyViewClick) {
                    onEmptyViewClick?.onEmptyViewClick()
                }
            }
            VIEW_TYPE_LOAD_DONE -> {
            }
            else ->
                super.onBindViewHolder(holder, position)
        }
    }


    override fun getItemCount(): Int {
        return getCount() + (if (enableLoadMore ) 1 else 0)
    }


    private fun getCount(): Int {
        return if (dataList.size == 0) {
            if (mEmptyEnable) 1 else 0
        } else {
            dataList.size
        }
    }

    private fun isListEmpty(): Boolean {
        return dataList.size == 0
    }


    override fun getItemViewType(position: Int): Int {
        if (enableLoadMore && isShowLoadMoreFooter&& position == getCount()) {
            return VIEW_TYPE_LOAD_MORE
        }
        if (isShowLoadDone && position == getCount()) {
            return VIEW_TYPE_LOAD_DONE
        }
        if (isListEmpty()) {
            return VIEW_TYPE_EMPTY_VIEW
        }

        return VIEW_TYPE_ITEM
    }


}