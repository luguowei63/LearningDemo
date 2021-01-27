package com.lgw.android.testmodule

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.testmodule.view.CommonView

class SecondActivity : AppCompatActivity() {

    lateinit var tvBind: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        tvBind=findViewById(R.id.tv_bind)
        tvBind.setOnClickListener {

//            val intent = Intent(this,SecondActivity::class.java)
//            this.startActivity(intent)

        }


//        val ballView = findViewById<CommonView>(R.id.ball_view)
//        val handler = Handler()
//        handler.postDelayed(object : Runnable {
//            override fun run() {
//                ballView.startCount = true
//                ballView.invalidate()
//                handler.postDelayed(this, 1000)
//            }
//        }, 1000)
    }
}