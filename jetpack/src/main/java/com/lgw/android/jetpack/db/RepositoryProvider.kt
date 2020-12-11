package com.lgw.android.jetpack.db

import android.content.Context
import com.lgw.android.jetpack.db.repository.ShoeRepository
import com.lgw.android.jetpack.db.repository.UserRepository

/**
 *Created by lgw on 2020/12/10
 */
object RepositoryProvider {


    fun createShoeRepository(context: Context) =
        ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())



    fun  crateUserRepository(context: Context)=UserRepository.getInstance(AppDataBase.getInstance(context).userDao())


}