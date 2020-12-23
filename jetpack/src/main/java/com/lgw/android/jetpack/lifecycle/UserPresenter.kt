package com.lgw.android.jetpack.lifecycle

import androidx.lifecycle.LifecycleOwner
import com.lgw.android.common.utils.L

/**
 *Created by lgw on 2020/12/15
 */
class UserPresenter :IPresenter{
    override fun onCreate(owner: LifecycleOwner) {
        L("I am UserPresenter onCreate")
        L(owner.lifecycle.toString())
    }

    override fun onStart(owner: LifecycleOwner) {
        L("I am UserPresenter onStart")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        L("I am UserPresenter onDestroy")
    }
}