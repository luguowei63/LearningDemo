package com.lgw.android.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class ProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)
        Handler().postDelayed({
            Log.e("TAG", "printer")
        }, 100 * 1000)

    }
    override fun onStop() {
        super.onStop()
        Log.e("TAG", "ProcessActivity  onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "ProcessActivity  onDestroy")
    }
}