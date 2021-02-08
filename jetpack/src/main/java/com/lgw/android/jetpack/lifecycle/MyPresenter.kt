package com.lgw.android.jetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 *Created by lgw on 2/5/21
 */
class MyPresenter :IPresenter {
    override fun onCreate(owner: LifecycleOwner) {
        Log.e("TAG","MyPresenter onCreate")

    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.e("TAG","MyPresenter onDestroy")

    }

    override fun onLifeCycleChanged(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.e("TAG","MyPresenter onLifeCycleChanged")

    }
}