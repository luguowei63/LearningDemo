package com.lgw.android.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lgw.android.jetpack.R
import kotlin.random.Random

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain4Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main4)
        val observableGoodsBean = ObservableGoodsBean("code", "hello", 25F)
        binding.observableGoods = observableGoodsBean
        binding.observableGoodsHandler = ObservableGoodsHandler(observableGoodsBean)
    }






   inner class ObservableGoodsHandler(private val  observableGoodsBean: ObservableGoodsBean){

        fun changeGoodsName(){
            Toast.makeText(this@MainActivity4, "1111", Toast.LENGTH_SHORT).show()

            observableGoodsBean.name.set("name    "+ Random.nextInt(100))
        }

        fun changeGoodsDetails(){
            observableGoodsBean.details.set("detail   "+ Random.nextInt(100))
            observableGoodsBean.price.set(Random.nextFloat())
        }
    }

}