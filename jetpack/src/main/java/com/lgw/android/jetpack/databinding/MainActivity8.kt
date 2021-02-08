package com.lgw.android.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import androidx.databinding.DataBindingUtil
import com.lgw.android.jetpack.R

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMain8Binding =DataBindingUtil.setContentView(this,R.layout.activity_main8)
        binding.list=ArrayList()
        val map= mutableMapOf<String,String>()
        map["leavesC"]="Hi"
        val set= mutableSetOf<String>()
        set.add("xxx")
        binding.map=map
        binding.key="leavesC"
        binding.set=set
        binding.array= arrayOf("Hi","Hello")
        val sparseArray=SparseArray<String>()
        sparseArray.append(0,"lgw")
        sparseArray.append(1,"lgw")
        sparseArray.append(2,"lgw")
        binding.sparse=sparseArray
    }
}