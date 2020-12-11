package com.lgw.android.jetpack.db.repository

import com.lgw.android.jetpack.db.dao.UserDao
import com.lgw.android.jetpack.db.data.User

/**
 *Created by lgw on 2020/12/11
 */
class UserRepository private constructor(private val userDao: UserDao) {


    fun insetUser(user: User) = userDao.insertUser(user)


    fun updateUser(user: User) = userDao.updateUser(user)

    fun deleteUser(user: User) = userDao.deleteUser(user)

    fun findUserById(id: Long) = userDao.findUserById(id)


    fun getAllUsers(): List<User> = userDao.getAllUsers()

    fun login(account: String, pwd: String): User = userDao.login(account, pwd)



    companion object{
        @Volatile
        private  var instance :UserRepository?=null

         fun getInstance(userDao: UserDao):UserRepository= instance?: synchronized(this){
            instance?:UserRepository(userDao).also {
                instance=it
            }
        }






    }

}