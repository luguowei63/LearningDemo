package com.lgw.android.jetpack.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lgw.android.jetpack.R
import kotlinx.android.synthetic.main.activity_test2.*

class TestActivity : AppCompatActivity() {

    private lateinit var mTestViewModel: TestViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        mTestViewModel = ViewModelProvider(this, ViewModelFactory())[TestViewModel::class.java]
        Log.e("TAG", "========================   ${mTestViewModel.toString()}")
        val statusObserver = Observer<String> {
            tv_num.text = it
        }

        mTestViewModel.getStatus().observe(this, statusObserver)


    }

    override fun onResume() {
        super.onResume()
        //更新数据
        mTestViewModel.getStatus().value = "ViewModel"
    }

    private class ViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TestViewModel() as T
        }
    }
}