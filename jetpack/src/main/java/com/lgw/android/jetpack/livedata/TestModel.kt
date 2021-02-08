package com.lgw.android.jetpack.livedata

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

/**
 *Created by lgw on 2/7/21
 */
class TestModel {


    private val status = MutableLiveData<String>()

    fun getStatus(): MutableLiveData<String> {
        return status
    }

    private val status1 = MutableLiveData<String>()

    fun getStatus1(): MutableLiveData<String> {
        return status1
    }
    private val liveDataMerger = MediatorLiveData<String>()


    fun getLiveDataMerger(): MediatorLiveData<String> {
        return liveDataMerger
    }

}