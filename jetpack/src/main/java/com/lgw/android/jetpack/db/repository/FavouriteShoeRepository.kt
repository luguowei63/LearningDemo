package com.lgw.android.jetpack.db.repository

import androidx.lifecycle.LiveData
import com.lgw.android.jetpack.db.dao.FavouriteShoeDao
import com.lgw.android.jetpack.db.data.FavouriteShoe

/**
 *Created by lgw on 2020/12/11
 */
class FavouriteShoeRepository private constructor(private val favouriteShoeDao: FavouriteShoeDao) {


    fun findFavouriteShoesByUserId(userId: String): LiveData<List<FavouriteShoe>> =
        favouriteShoeDao.findFavouriteShoesByUserId(userId)

    fun findFavouriteShoeByUserIdAndShoeId(userId: Long, shoeId: Long): LiveData<FavouriteShoe?> =
        favouriteShoeDao.findFavouriteShoeByUserIdAndShoeId(userId, shoeId)

    // 插入单个FavouriteShoe
    fun insertFavouriteShoe(favouriteShoe: FavouriteShoe) =
        favouriteShoeDao.insertFavouriteShoe(favouriteShoe)

    // 删除单个FavouriteShoe
    fun deleteFavouriteShoe(favouriteShoe: FavouriteShoe) =
        favouriteShoeDao.deleteFavouriteShoe(favouriteShoe)

    // 删除多个FavouriteShoe
    fun deleteFavouriteShoes(favouriteShoes: List<FavouriteShoe>) =
        favouriteShoeDao.deleteFavouriteShoes(favouriteShoes)


    companion object {

        private var instance: FavouriteShoeRepository? = null

        fun getInstance(favouriteShoeDao: FavouriteShoeDao): FavouriteShoeRepository =
            instance ?: synchronized(this) {
                instance ?: FavouriteShoeRepository(favouriteShoeDao).also { instance = it }
            }


    }


}