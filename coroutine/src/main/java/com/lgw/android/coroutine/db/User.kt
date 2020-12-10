package com.lgw.android.coroutine.db

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 *Created by lgw on 2020/12/9
 */

@Entity(tableName = "user", primaryKeys = ["id"])
data class User
    (
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int
)


