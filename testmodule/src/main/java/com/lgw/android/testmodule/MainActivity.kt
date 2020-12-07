package com.lgw.android.testmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.customer.PullRecycleView
import com.lgw.android.pullto.layoutmanager.XLinearLayoutManager

class MainActivity : AppCompatActivity(), PullRecycleView.OnRecyclerRefreshListener {

    private lateinit var recycleView: PullRecycleView
    private val layoutManager = XLinearLayoutManager(this)
    private val list = mutableListOf<ItemBean>()
    private lateinit var adapter: RecycleViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (index in 0..15) {
            val itemBean = ItemBean()
            list.add(itemBean)
        }
        recycleView = findViewById(R.id.prv_recycle_view)
        adapter = RecycleViewAdapter(this, list, R.layout.test_recycle_item)
        recycleView.setAdapter(adapter)
        recycleView.setLayoutManager(layoutManager)
        recycleView.onRecyclerRefreshListener = this

    }

    override fun onPullRefresh() {
        list.clear()
        recycleView.finishRefresh()
        for (index in 0..15) {
            val itemBean = ItemBean()
            list.add(itemBean)
        }

        adapter.notifyDataSetChanged()

    }

    override fun onLoadMore() {
        recycleView.postDelayed({
            recycleView.loadDone()
            for (index in 0..15) {
                val itemBean = ItemBean()
                list.add(itemBean)
            }
            adapter.notifyDataSetChanged()
        }, 2 * 1000)


    }
}