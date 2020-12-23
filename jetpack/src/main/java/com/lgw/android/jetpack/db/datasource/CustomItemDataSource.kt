package com.lgw.android.jetpack.db.datasource

import androidx.paging.ItemKeyedDataSource
import com.lgw.android.jetpack.db.data.Shoe

/**
 *Created by lgw on 2020/12/21
 */
class CustomItemDataSource : ItemKeyedDataSource<Int, Shoe>() {
    override fun getKey(item: Shoe): Int {
        TODO("Not yet implemented")
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Shoe>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Shoe>) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Shoe>) {
        TODO("Not yet implemented")
    }
}