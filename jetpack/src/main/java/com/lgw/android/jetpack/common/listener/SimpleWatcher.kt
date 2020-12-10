package com.lgw.android.jetpack.common.listener

import android.text.Editable
import android.text.TextWatcher

/**
 *Created by lgw on 2020/12/10
 */
open class SimpleWatcher:TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
    }
}