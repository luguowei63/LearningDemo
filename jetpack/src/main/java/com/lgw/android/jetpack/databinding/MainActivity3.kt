package com.lgw.android.jetpack.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import com.lgw.android.jetpack.BR
import com.lgw.android.jetpack.R
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {
    private val TAG = "Main3Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val binding: ActivityMain3Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main3)

        val goods = GoodsBean()
        goods.name = "code"
        goods.detail = "hi"
        goods.price = 24f

        binding.goods = goods
        binding.goodsHandler = GoodsHandler(goods)
        goods.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (propertyId) {
                    BR.name -> {
                        Log.e(TAG, "BR.name")
                    }
                    BR.detail -> {
                        Log.e(TAG, "BR.detail")
                    }
                    BR._all -> {
                        Log.e(TAG, "BR._all")
                    }
                    else -> {
                        Log.e(TAG, "未知")
                    }
                }
            }
        })

    }

    class GoodsHandler(private val goodsBean: GoodsBean) {

        fun changeGoodsName() {
            goodsBean.price = Random.nextFloat()
            goodsBean.name = "code " + Random.nextInt(100)
        }

        fun changeGoodsDetails() {
            goodsBean.price = Random.nextFloat()
            goodsBean.detail = "hi " + Random.nextInt(100)
        }


    }


}