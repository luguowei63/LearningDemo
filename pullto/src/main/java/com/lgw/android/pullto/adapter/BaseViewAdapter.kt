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
open abstract class BaseViewAdapter<T>(
    context: Context,
    mutableList: MutableList<T>,
    layoutResId: Int
) : RecyclerView.Adapter<BaseViewHolder>() {
    interface OnItemClickListener<I> {
        fun onItemClick(item: I, position: Int)
    }

    interface OnItemLongClickListener<I> {
        fun onItemLongClick(item: I, position: Int)
    }

    protected val mContext = context

    var dataList: MutableList<T> = mutableList
    var view: View = LayoutInflater.from(context).inflate(layoutResId, null)
    var onItemClickListener: OnItemClickListener<T>? = null
    var onItemLongClickListener: OnItemLongClickListener<T>? = null


    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return convertViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        convertItemView(holder, position, dataList[position])
        initItemClickListener(holder, position, dataList[position])
    }


    protected fun convertViewHolder(view: View): BaseViewHolder {
        return BaseViewHolder(view)
    }


    protected fun convertItemView(holder: BaseViewHolder, position: Int, item: T) {
        convert(holder, item)
    }


    protected abstract fun convert(holder: BaseViewHolder, item: T)


    private fun initItemClickListener(holder: BaseViewHolder, position: Int, item: T) {
        onItemClickListener?.let {
            holder.getConvertView().setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    onItemClickListener!!.onItemClick(item, position)
                }
            })
        }
        onItemLongClickListener?.let {
            holder.getConvertView().setOnLongClickListener(object : View.OnLongClickListener {

                override fun onLongClick(v: View?): Boolean {
                    onItemLongClickListener!!.onItemLongClick(item, position)
                    return true
                }
            })
        }

    }


    protected fun removeItemAtIndex(position: Int): Boolean {
        if (position > 0 && dataList.size > position) {
            dataList.removeAt(position)
            notifyItemRemoved(position)
            return true
        }

        return false
    }


      fun insertItemAtIndex(position: Int,item: T):Boolean{
        if (position>0&&dataList.size>position){
            dataList.add(position,item)
            notifyItemInserted(position)
            return true
        }
        return false
    }

      fun replaceItemAtIndex(position: Int,item: T):Boolean{
        if (position>0&&dataList.size>position){
            dataList[position] = item
            notifyItemChanged(position)
            return true
        }
        return false
    }

      fun moveItemAtIndex(fromPosition: Int,toPosition: Int,fromItem: T,toItem: T):Boolean{
        if (fromPosition>0&&dataList.size>toPosition&&toPosition>0&&dataList.size>toPosition){
            dataList[fromPosition] = toItem
            dataList[toPosition] = fromItem
            notifyItemMoved(fromPosition,toPosition)
            return true
        }
        return false
    }

     fun addAllData(list: MutableList<T>){
         dataList.addAll(list)
         notifyDataSetChanged()
     }





    protected fun clearAllData() {
        dataList.clear()
        notifyDataSetChanged()
    }


}