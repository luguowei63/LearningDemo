package com.lgw.android.testmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lgw.android.testmodule.view.BallView
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        var ballView=findViewById<BallView>(R.id.ball_view)
//        Timer().schedule(object :TimerTask(){
//            override fun run() {
//                ballView.postInvalidate()
//            }
//        },200,50)
    }
}