package com.lgw.android.jetpack.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lgw.android.jetpack.db.data.Shoe

/**
 *Created by lgw on 2020/12/10
 */
@Dao
interface ShoeDao {
    //通过鞋子的范围寻找Index
    @Query("SELECT * FROM shoe WHERE id between :startIndex AND :endIndex ORDER BY  id ASC")
    fun findShoesByIndexRange(startIndex: Long, endIndex: Long): List<Shoe>

    //配合LiveData 返回所有的鞋子
    @Query("SELECT * FROM shoe")
    fun getAllShoesLD(): List<Shoe>

    //配合LiveData 通过ID查询单款鞋子
    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeByIdLD(id: Long): Shoe

    //通过品牌查询鞋子
    @Query("SELECT *  FROM shoe WHERE shoe_brand IN (:brand)")
    fun findShoesByBrandLD(brand: Array<String>): LiveData<Shoe>



    //增加一双鞋
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    //增加多双鞋
    //除了List之外,也可以使用数组
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoe: List<Shoe>)

    // 删除一双鞋子
    @Delete
    fun deleteShoe(shoe: Shoe)

    // 删除多个鞋子
    // 参数也可以使用数组
    @Delete
    fun deleteShoes(shoes: List<Shoe>)

    // 更新一双鞋
    @Update
    fun updateShoe(shoe: Shoe):Int

    // 更新多双鞋
    // 参数也可以是集合
    @Update
    fun updateShoes(shoes: Array<Shoe>)
























}