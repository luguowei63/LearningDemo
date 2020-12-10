package com.lgw.android.jetpack.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *Created by lgw on 2020/12/10
 */
@Entity(tableName = "shoe")
data class Shoe(
    @ColumnInfo(name = "shoe_name") val name: String,
    @ColumnInfo(name = "shoe_description") val description: String,
    @ColumnInfo(name = "shoe_price") val price: Float,
    @ColumnInfo(name = "shoe_brand") var brand: String,
    @ColumnInfo(name = "shoe_imgUrl") val imageUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
    override fun toString(): String {
        return "Shoe(name='$name', description='$description', price=$price, brand='$brand', imageUrl='$imageUrl', id=$id)"
    }
}