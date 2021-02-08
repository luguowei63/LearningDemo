package com.lgw.android.jetpack.databinding

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.lgw.android.jetpack.R
import java.util.*

class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       DataBindingUtil.setContentView<ActivityMain9Binding>(this,R.layout.activity_main9)
    }









}