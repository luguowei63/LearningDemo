package com.lgw.android.jetpack.common

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import javax.sql.DataSource

/**
 *Created by lgw on 2020/12/21
 */


fun <T> androidx.paging.DataSource.Factory<Int, T>.createPagerList(
    pageSize: Int,
    defaultSize: Int
): LiveData<PagedList<T>> {
    return LivePagedListBuilder<Int, T>(
        this, PagedList.Config.Builder()
            .setPageSize(2)
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(2).build()
    ).build()
}