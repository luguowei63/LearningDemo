package com.lgw.android.jetpack.databinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import com.lgw.android.jetpack.R
import kotlin.random.Random

class MainActivity5 : AppCompatActivity() {


    private val map = ObservableArrayMap<String, String>().apply {
        put("name", "leavesC")
        put("age", "24")
    }


    private val list = ObservableArrayList<String>().apply {
        add("Ye")
        add("leavesC")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain5Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main5)
        binding.map = map
        binding.list = list
        binding.index = 0
        binding.key = "name"
        binding.handler=ClickHandler()
    }


    fun onClick(view: View, name: String) {
        Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show()
        map["name"] = "leavesC," + Random.nextInt(100)
    }


    inner class ClickHandler {

        fun onClick(view: View,name:String) {
            Toast.makeText(this@MainActivity5, "1111", Toast.LENGTH_SHORT).show()
        }

        fun onClick(view: View) {
            Toast.makeText(this@MainActivity5, "2222", Toast.LENGTH_SHORT).show()
        }
    }


}