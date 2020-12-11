package com.lgw.android.jetpack.db.dao

import androidx.room.*
import com.lgw.android.jetpack.db.data.User

/**
 *Created by lgw on 2020/12/11
 */
@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User):Long

    @Update
    fun updateUser(user: User)


    @Delete
    fun deleteUser(user:User)

    @Query("SELECT * FROM user WHERE id =:id")
    fun findUserById(id:Long):User


    @Query("SELECT * FROM user")
    fun getAllUsers():List<User>



    @Query("SELECT*FROM user WHERE user_account=:account AND user_pwd=:pwd")
    fun login(account:String,pwd :String):User







}