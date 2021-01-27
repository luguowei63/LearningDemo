package com.lgw.android.testmodule

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.customer.PullRecycleView
import com.lgw.android.pullto.layoutmanager.XLinearLayoutManager
import com.lgw.android.testmodule.aidl.PushManager


class MainActivity : AppCompatActivity(){
    private lateinit var recycleView: PullRecycleView
    private val layoutManager = XLinearLayoutManager(this)
    private val list = mutableListOf<ItemBean>()
    private lateinit var adapter: RecycleViewAdapter
    lateinit var tvBind: TextView
    private var btn: Button? = null
    private  var btnSend:Button? = null
    private var et: EditText? = null
    private var isConnected = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        et = findViewById(R.id.et)
        btnSend = findViewById(R.id.send)
        PushManager.getInstance().init(this)
        btn!!.setOnClickListener(View.OnClickListener {

            PushManager.getInstance().connect()
            isConnected = true
        })
        btnSend!!.setOnClickListener {
            if (!isConnected) {
                Toast.makeText(this@MainActivity, "请连接", Toast.LENGTH_LONG).show()
            }
            if (et!!.text.toString().trim { it <= ' ' }.isEmpty()) {
                Toast.makeText(this@MainActivity, "请输入", Toast.LENGTH_LONG).show()
            }
            PushManager.getInstance().sendString(et!!.text.toString())
        }
//        tvBind=findViewById(R.id.tv_bind)
//        tvBind.setOnClickListener {
//
//            val intent = Intent(this,SecondActivity::class.java)
//            this.startActivity(intent)
//
//        }




//        BindViewFactory.inject(this)
//        for (index in 0..15) {
//            val itemBean = ItemBean()
//            list.add(itemBean)
//        }
//        recycleView = findViewById(R.id.prv_recycle_view)
//        adapter = RecycleViewAdapter(this, list, R.layout.test_recycle_item)
//        recycleView.setAdapter(adapter)
//        recycleView.setLayoutManager(layoutManager)
//        recycleView.onRecyclerRefreshListener = this
//
//
//        lifecycle.addObserver(adapter)


    }

//    override fun onPullRefresh() {
//        list.clear()
//        recycleView.finishRefresh()
//        for (index in 0..15) {
//            val itemBean = ItemBean()
//            list.add(itemBean)
//        }
//
//        adapter.notifyDataSetChanged()
//
//    }
//
//    override fun onLoadMore() {
//        recycleView.postDelayed({
//            recycleView.loadDone()
//            for (index in 0..15) {
//                val itemBean = ItemBean()
//                list.add(itemBean)
//            }
//            adapter.notifyDataSetChanged()
//        }, 2 * 1000)
//    }
//
//
//    override fun onDestroy() {
//        super.onDestroy()
//        lifecycle.removeObserver(adapter)
//    }

}