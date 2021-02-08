package com.lgw.android.jetpack.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lgw.android.jetpack.R

class MainActivity : AppCompatActivity() {

    private  lateinit var myPresenter: MyPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        myPresenter= MyPresenter()
        lifecycle.addObserver(myPresenter)
        Log.e("TAG","MainActivity onCreate")
    }

    override fun onDestroy() {
        Log.e("TAG","MainActivity onDestroy")
        super.onDestroy()


    }



}