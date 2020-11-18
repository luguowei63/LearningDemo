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
class BasePullToAdapter<T>(context: Context, mutableList: MutableList<T>, layoutResId: Int) :
    BaseViewAdapter<T>(context, mutableList, layoutResId) {



    init {

    }

    companion object {
        val VIEW_TYPE_LOAD_PULL = 100
        val VIEW_TYPE_LOAD_START = 101
        val VIEW_TYPE_LOAD_DONE = 102
        val VIEW_TYPE_EMPTY_VIEW = 103
        val VIEW_TYPE_ITEM = 104
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var viewHolder: BaseViewHolder

        when (viewType) {
            VIEW_TYPE_LOAD_PULL -> {
                val footView=LayoutInflater.from(mContext).inflate(R.layout.pullto_item_footer,parent,false);
                viewHolder= BaseViewHolder(footView)
                return viewHolder
            }
            VIEW_TYPE_LOAD_START -> {
                val footView=LayoutInflater.from(mContext).inflate(R.layout.pullto_item_footer,parent,false);
                viewHolder= BaseViewHolder(footView)
                return viewHolder
            }
            VIEW_TYPE_LOAD_DONE -> {
                val footView=LayoutInflater.from(mContext).inflate(R.layout.pullto_item_footer,parent,false);
                viewHolder= BaseViewHolder(footView)
                viewHolder.setVisibility(R.id.pb_bar, View.GONE)
                return viewHolder
            }

            VIEW_TYPE_EMPTY_VIEW -> {
                val footView=LayoutInflater.from(mContext).inflate(R.layout.pullto_item_footer,parent,false);
                viewHolder= BaseViewHolder(footView)
                return viewHolder
            }
            VIEW_TYPE_ITEM -> {
                viewHolder= super.onCreateViewHolder(parent, viewType)
                return viewHolder
            }
        }




    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    override fun convert(holder: BaseViewHolder, item: T) {
    }


}