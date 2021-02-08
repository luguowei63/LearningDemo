package com.lgw.android.jetpack.livedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.jetpack.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    private val mTestModel = TestModel()
    private  val buffer=StringBuffer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        mTestModel.getLiveDataMerger().observe(this) {
            buffer.append(it)
            tv_count.text = buffer.toString()

        }


        mTestModel.getLiveDataMerger().addSource(
            mTestModel.getStatus()
        ) {

            mTestModel.getLiveDataMerger().value = it

        }

        mTestModel.getLiveDataMerger().addSource(
            mTestModel.getStatus1()
        ) {

            mTestModel.getLiveDataMerger().value = it

        }
    }


    override fun onResume() {
        super.onResume()
        mTestModel.getStatus().value = "lgw"
        Thread.sleep(2 * 1000)
        mTestModel.getStatus1().value = "123456"


        mTestModel.getLiveDataMerger().removeSource(mTestModel.getStatus1())


        mTestModel.getStatus().value = "LUGUOWEI"
        Thread.sleep(2 * 1000)
        mTestModel.getStatus1().value = "654321"


    }


}