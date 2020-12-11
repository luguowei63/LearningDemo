package com.lgw.android.jetpack.db.repository

import com.lgw.android.jetpack.db.dao.ShoeDao
import com.lgw.android.jetpack.db.data.Shoe

/**
 *Created by lgw on 2020/12/10
 * 使用抽象工厂模式定义获取ShoeRepository的对象，
 * 减少了ShoeDao对象耦合的可能
 */
class ShoeRepository private constructor(private val shoeDao: ShoeDao) {

    /**
     * 通过id的范围寻找鞋子
     */

      fun getPageShoes(startIndex: Long, endIndex: Long): List<Shoe> =
        shoeDao.findShoesByIndexRange(startIndex, endIndex)

      fun getAllShoes() = shoeDao.getAllShoesLD()

    /**
     * 通过品牌查询鞋子
     */

    suspend fun getShoesBtBrand(brand: Array<String>) = shoeDao.findShoesByBrandLD(brand)

    /**
     * 通过ID查询鞋子
     */
     fun getShoeById(id: Long): Shoe = shoeDao.findShoeByIdLD(id)

    /**
     * 查询用户收藏的鞋子
     */
//    fun  getShoeByUserId(userId:Long)=shoeDao.findShoesByUserId(userId)


    /**
     * 插入鞋子的集合
     */
      fun insertShoes(shoes: List<Shoe>) = shoeDao.insertShoes(shoes)


     fun insertShoe(shoe: Shoe) = shoeDao.insertShoe(shoe)

     fun updateShoe(shoe: Shoe) = shoeDao.updateShoe(shoe)

     fun deleteShoe(shoe: Shoe) = shoeDao.deleteShoe(shoe)


      fun deleteShoes(shoes: List<Shoe>) = shoeDao.deleteShoes(shoes)

    companion object {

        @Volatile
        private var instance: ShoeRepository? = null

        fun getInstance(shoeDao: ShoeDao): ShoeRepository =
            instance ?: synchronized(this) {
                instance ?: ShoeRepository(shoeDao).also {
                    instance = it
                }
            }
    }


}