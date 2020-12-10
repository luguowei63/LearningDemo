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

    fun getPageShoes(startIndex:Long,endIndex:Long):List<Shoe> = shoeDao.findShoesByIndexRange(startIndex,endIndex)






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