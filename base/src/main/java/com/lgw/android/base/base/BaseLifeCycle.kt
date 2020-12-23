package com.lgw.android.base.base

import androidx.lifecycle.LifecycleOwner
import com.lgw.android.base.interfaces.DefaultLifeCycle

/**
 *Created by lgw on 2020/12/15
 */
open class BaseLifeCycle:DefaultLifeCycle {
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
    }

    override fun onStart(lifecycleOwner: LifecycleOwner) {
    }

    override fun onResume(lifecycleOwner: LifecycleOwner) {
    }

    override fun onPause(lifecycleOwner: LifecycleOwner) {
    }

    override fun onStop(lifecycleOwner: LifecycleOwner) {
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
    }

    override fun onAnyEvent(lifecycleOwner: LifecycleOwner) {
    }
}