package com.lgw.android.jetpack.databinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lgw.android.jetpack.R

class MainActivity7 : AppCompatActivity() {


    private val binding: ActivityMain7Binding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main7)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.handler = Handler()
        val user = UserBean("leacesC", "123456")
        binding.userInfo = user
        binding.viewStub.setOnInflateListener { _, view ->
            // 如果在XML中没有使用bind：userInfo="@{userInfo}" 对ViewStub进行数据绑定
            //那么可以在此进行过手动绑定
            val viewStubBinding: ViewStubBinding? = DataBindingUtil.bind(view)
            viewStubBinding?.let {
                viewStubBinding.userInfo = user
            }
        }
    }


    inner class Handler {
        fun onClick(v: View) {
           if (!binding.viewStub.isInflated){
               binding.viewStub.viewStub?.inflate()
           }
        }


    }


}