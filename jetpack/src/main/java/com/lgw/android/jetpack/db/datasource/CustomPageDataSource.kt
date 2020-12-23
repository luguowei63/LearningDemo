package com.lgw.android.jetpack.db.datasource

import androidx.paging.PageKeyedDataSource
import com.lgw.android.jetpack.db.data.Shoe
import com.lgw.android.jetpack.db.repository.FavouriteShoeRepository

/**
 *Created by lgw on 2020/12/21
 */
class CustomPageDataSource (private val shoeRepository: FavouriteShoeRepository):
    PageKeyedDataSource<Int, Shoe>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Shoe>
    ) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Shoe>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Shoe>) {
        TODO("Not yet implemented")
    }
}