package com.lgw.android.jetpack.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *Created by lgw on 2020/12/10
 * 用户表
 */
@Entity(tableName = "User")
data class User(
    @ColumnInfo(name = "user_account") val account: String//账号
    , @ColumnInfo(name = "user_pwd") val pwd: String//密码
    , @ColumnInfo(name = "user_name") val name: String//姓名
    , @ColumnInfo(name = "user_url") var headImage: String//头像地址

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0


}