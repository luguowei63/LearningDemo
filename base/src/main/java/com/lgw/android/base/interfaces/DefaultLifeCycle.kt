package com.lgw.android.base.interfaces

import androidx.annotation.NonNull
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 *Created by lgw on 2020/12/15
 */
interface DefaultLifeCycle : LifecycleObserver {
    /**
     * LifeCycle中的onCreate监听
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(@NonNull lifecycleOwner: LifecycleOwner)


    /**
     * LifeCycle中的onStart监听
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(@NonNull lifecycleOwner: LifecycleOwner)


    /**
     * LifeCycle中的onResume监听
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(@NonNull lifecycleOwner: LifecycleOwner)


    /**
     * LifeCycle中的onPause监听
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(@NonNull lifecycleOwner: LifecycleOwner)

    /**
     * LifeCycle中的onStop监听
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(@NonNull lifecycleOwner: LifecycleOwner)

    /**
     * LifeCycle中的onDestroy监听
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(@NonNull lifecycleOwner: LifecycleOwner)


    /**
     * 以上所有监听均会回调此函数
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAnyEvent(@NonNull lifecycleOwner: LifecycleOwner)


}