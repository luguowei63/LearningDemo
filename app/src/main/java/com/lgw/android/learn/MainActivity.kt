package com.lgw.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var tv1: TextView
    lateinit var tv2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1 = findViewById(R.id.tv_go_to_1)
        tv2 = findViewById(R.id.tv_go_to_2)
        tv1.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ProcessActivity::class.java)
            this.startActivity(intent)
        }
    }


}