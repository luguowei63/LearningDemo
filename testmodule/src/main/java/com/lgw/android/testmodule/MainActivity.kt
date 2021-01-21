package com.lgw.android.testmodule

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.apt_annotation.BindView
import com.lgw.android.apt_library.BindViewFactory
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.customer.PullRecycleView
import com.lgw.android.pullto.layoutmanager.XLinearLayoutManager

class MainActivity : AppCompatActivity(), PullRecycleView.OnRecyclerRefreshListener {
    private lateinit var recycleView: PullRecycleView
    private val layoutManager = XLinearLayoutManager(this)
    private val list = mutableListOf<ItemBean>()
    private lateinit var adapter: RecycleViewAdapter
    @BindView(R.id.tv_bind)
    lateinit var tvBind: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BindViewFactory.inject(this)
        for (index in 0..15) {
            val itemBean = ItemBean()
            list.add(itemBean)
        }
        recycleView = findViewById(R.id.prv_recycle_view)
        adapter = RecycleViewAdapter(this, list, R.layout.test_recycle_item)
        recycleView.setAdapter(adapter)
        recycleView.setLayoutManager(layoutManager)
        recycleView.onRecyclerRefreshListener = this


        lifecycle.addObserver(adapter)


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


    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(adapter)
    }

}