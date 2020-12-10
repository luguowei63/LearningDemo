package com.lgw.android.jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lgw.android.jetpack.db.dao.ShoeDao
import com.lgw.android.jetpack.db.data.Shoe

/**
 *Created by lgw on 2020/12/10
 */

@Database(entities = [Shoe::class],version = 1)
abstract  class AppDataBase:RoomDatabase() {

    abstract fun shoeDao(): ShoeDao


    companion object{
        @Volatile
        private var  instance:AppDataBase?=null

        fun getInstance(context: Context):AppDataBase{
            return instance?: synchronized(this){
                instance?:buildDataBase(context)
                    .also {
                        instance = it
                    }
            }
        }



        private  fun buildDataBase(context: Context):AppDataBase{
            return Room.databaseBuilder(context,AppDataBase::class.java,"jetPackDemo-database").build()
        }

    }


}