package com.lgw.android.pullto.viewholder

import android.content.Context
import android.text.TextUtils
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 *Created by lgw on 2020/11/11
 */
class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    /**
     *  View ID 集合
     */
    private val viewsArray: SparseArray<View?> = SparseArray()

    private var mContext: Context = view.context

    private var itemView: View = view


    //------------------------
    //  MVVM 模式中涉及到数据更新的方法，将不会在使用
    //------------------------

    /**
     * 设置TextView中的数据
     */

    fun setTextValue(resId: Int, content: String) {
        if (TextUtils.isEmpty(content))
            return
        val view = getView<TextView>(resId)
        view.text = content
    }

    /**
     * 设置图片
     */


    fun setImgSrc(resId: Int, imgId: Int) {
        val view = getView<ImageView>(resId)
        view.setImageResource(resId)

    }


    fun setImgSrc(resId: Int, imgSrc: String) {
        if (TextUtils.isEmpty(imgSrc))
            return
        val view = getView<ImageView>(resId)
        Glide.with(mContext).load(imgSrc).into(view);
    }


    fun <T : View?> getView(viewId: Int): T {
        var view: View? = viewsArray[viewId]
        if (view == null) {
            view = itemView.findViewById(viewId)
            viewsArray.put(viewId, view)
        }
        return view!! as T
    }


}