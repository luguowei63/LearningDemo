package com.lgw.android.testmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.common.utils.L
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.customer.PullRecycleView
import com.lgw.android.pullto.layoutmanager.XLinearLayoutManager

class MainActivity : AppCompatActivity(), PullRecycleView.OnRecyclerRefreshListener {

    private lateinit var recycleView: PullRecycleView<ItemBean>
    private val layoutManager = XLinearLayoutManager(this)
    private val list = mutableListOf<ItemBean>()
    private lateinit var adapter :RecycleViewAdapter<ItemBean>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (index in 0..15) {
            var itemBean = ItemBean()
            list.add(itemBean)
        }
        recycleView = findViewById(R.id.prv_recycle_view)
        recycleView.onRecyclerRefreshListener = this
        adapter = RecycleViewAdapter(this, list, R.layout.test_recycle_item)
        recycleView.setAdapter(adapter)
        recycleView.setLayoutManager(layoutManager)

    }

    override fun onPullRefresh() {
        list.clear()
        recycleView.finishRefresh()
        for (index in 0..5) {
            val itemBean = ItemBean()
            list.add(itemBean)
        }

        adapter.notifyDataSetChanged()

    }

    override fun onLoadMore() {
        recycleView.finishLoadMore()
        for (index in 0..15) {
            var itemBean = ItemBean()
            list.add(itemBean)
        }
        adapter.notifyDataSetChanged()

    }
}