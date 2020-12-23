package com.lgw.android.jetpack.binding

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lgw.android.jetpack.R
import com.lgw.android.jetpack.common.listener.SimpleWatcher

/**
 *Created by lgw on 2020/12/21
 */

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view:ImageView,imageUrl: String?){
    if(!imageUrl.isNullOrEmpty()){
        Glide.with(view.context)
            .asBitmap()
            .load(imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop()
            .into(view)
    }

}



@BindingAdapter("addTextChangedListener")
fun addTextChangedListener(editText: EditText, simpleWatcher: SimpleWatcher) {
    editText.addTextChangedListener(simpleWatcher)
}