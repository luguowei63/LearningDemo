package com.lgw.android.pullto.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lgw.android.pullto.viewholder.BaseViewHolder

/**
 *Created by lgw on 2020/11/12
 */
open class BaseViewAdapter(context: Context) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    }
}