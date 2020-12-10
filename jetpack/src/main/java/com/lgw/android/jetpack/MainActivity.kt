package com.lgw.android.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lgw.android.jetpack.db.AppDataBase
import com.lgw.android.jetpack.db.data.Shoe

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataBase= AppDataBase.getInstance(this)
        val shoe=Shoe("dunk 1","Fashion shoe",3200F,"NICK","http://******.jpg")
        println(shoe.toString())
        val shoeDao=dataBase.shoeDao()
        shoeDao.insertShoe(shoe)
        println(shoeDao.findShoeByIdLD(shoe.id))
        shoe.brand="ADIDAS"
        shoeDao.updateShoe(shoe)

        println(shoeDao.findShoeByIdLD(shoe.id))

    }
}