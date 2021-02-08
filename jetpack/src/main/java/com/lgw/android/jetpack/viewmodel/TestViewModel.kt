package com.lgw.android.jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *Created by lgw on 2/7/21
 */
class TestViewModel : ViewModel() {

     private val status =MutableLiveData<String>()



    fun  getStatus():MutableLiveData<String>{
        return status
    }



}