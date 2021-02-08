package com.lgw.android.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations

/**
 *Created by lgw on 2/7/21
 */
class TestLiveData : LiveData<String>() {
    /**
     * 当有一个处于活跃状态的观察者监听LiveData时会被调用
     */
    override fun onActive() {
        super.onActive()
    }


    /**
     * 没有任何处于活动装填的监听者监听LiveData时会被调用，由于没有观察者在监听了，所以
     * 可以做一些释放操作
     */

    override fun onInactive() {
        super.onInactive()
         }









}