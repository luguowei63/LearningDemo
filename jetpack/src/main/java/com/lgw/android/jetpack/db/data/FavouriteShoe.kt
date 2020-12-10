package com.lgw.android.jetpack.db.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

/**
 *Created by lgw on 2020/12/10
 */

data class FavouriteShoe(
    @ColumnInfo(name = "shoe_id") val shoeId: Long // 外键 鞋子的id
    , @ColumnInfo(name = "user_id") val userId: Long // 外键 用户的id
    , @ColumnInfo(name = "fav_date") val date: Calendar // 创建日期
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}