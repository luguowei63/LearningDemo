package com.lgw.android.testmodule

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.testmodule.view.CommonView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val ballView = findViewById<CommonView>(R.id.ball_view)
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                ballView.startCount = true
                ballView.invalidate()
                handler.postDelayed(this, 1000)
            }
        }, 1000)
    }
}