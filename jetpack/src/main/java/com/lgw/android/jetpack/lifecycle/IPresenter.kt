package com.lgw.android.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 *Created by lgw on 2/5/21
 */
interface IPresenter : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(owner: LifecycleOwner)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner)


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onLifeCycleChanged(owner: LifecycleOwner, event: Lifecycle.Event)


}