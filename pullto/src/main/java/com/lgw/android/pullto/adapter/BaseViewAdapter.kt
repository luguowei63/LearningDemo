package com.lgw.android.pullto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lgw.android.pullto.viewholder.BaseViewHolder

/**
 *Created by lgw on 2020/11/12
 */
open abstract  class BaseViewAdapter<T>(context: Context, mutableList: MutableList<T>, layoutResId: Int) : RecyclerView.Adapter<BaseViewHolder>() {
    var dataList: MutableList<T> = mutableList
    var view: View = LayoutInflater.from(context).inflate(layoutResId, null)


    interface  OnItemClickListener{
        fun onItemClick(view: View,position: Int)
    }

    interface  OnItemLongClickListener{
        fun onItemLongClick(view: View,position: Int)
    }



    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return convertViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        convertItemView(holder, position, dataList[position])
        initItemClickListener()
    }


    protected fun convertViewHolder(view: View): BaseViewHolder {
        return BaseViewHolder(view)
    }


    protected fun convertItemView(holder: BaseViewHolder, position: Int, item: T) {
        convert(holder, item)
    }


    protected abstract fun convert(holder: BaseViewHolder, item: T)




    private fun initItemClickListener(){

    }










}