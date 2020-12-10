package com.lgw.android.coroutine.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.lgw.android.coroutine.appContext

/**
 *Created by lgw on 2020/12/9
 */

abstract class DB :RoomDatabase(){

    abstract fun userDao():UserDao

    companion object{
       private  val instance by lazy {
            Room.databaseBuilder(appContext,DB::class.java,"user_db").build()
        }

        val userDao by lazy{
            DB.instance.userDao()
        }



    }


}
