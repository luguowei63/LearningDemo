package com.lgw.android.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lgw.android.jetpack.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMain2Binding=DataBindingUtil.setContentView(this,R.layout.activity_main2)
        val user=UserBean("leave","123456")
        binding.userInfo=user
        val goods=ObservableGoodsBean("code", "coding", 23F)
        binding.goods = goods
    }
}