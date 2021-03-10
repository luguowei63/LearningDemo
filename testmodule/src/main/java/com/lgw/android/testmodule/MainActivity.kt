package com.lgw.android.testmodule

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.pullto.bean.ItemBean
import com.lgw.android.pullto.customer.PullRecycleView
import com.lgw.android.pullto.layoutmanager.XLinearLayoutManager
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    private lateinit var recycleView: PullRecycleView
    private val layoutManager = XLinearLayoutManager(this)
    private val list = mutableListOf<ItemBean>()
    private lateinit var adapter: RecycleViewAdapter
    lateinit var tvBind: TextView
    private var btn: Button? = null
    private var btnSend: Button? = null
    private var et: EditText? = null
    private var isConnected = false
    private lateinit var myInterface: IMyAidlInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
//        btn = findViewById(R.id.btn)
//        et = findViewById(R.id.et)
//        btnSend = findViewById(R.id.send)
//        PushManager.getInstance().init(this)
//        btn!!.setOnClickListener(View.OnClickListener {
//
//            PushManager.getInstance().connect()
//            isConnected = true
//        })
//        btnSend!!.setOnClickListener {
//
//            val intent =Intent("com.lgw.android.aidl_server.MyService")
//            intent.`package`="com.lgw.android.aidl_server"
//           bindService(intent,OnServiceConnection(myInterface),Service.BIND_AUTO_CREATE)
//
//
//
//            if (!isConnected) {
//                Toast.makeText(this@MainActivity, "请连接", Toast.LENGTH_LONG).show()
//            }
//            if (et!!.text.toString().trim { it <= ' ' }.isEmpty()) {
//                Toast.makeText(this@MainActivity, "请输入", Toast.LENGTH_LONG).show()
//            }
//            PushManager.getInstance().sendString(et!!.text.toString())
    }

    private fun main() {
        val intent= Intent("com.lgw.android.testmodule.service.MyIntentService")

        val bundle=Bundle()
        bundle.putString("taskName","task1")

        intent.setPackage("com.lgw.android.testmodule.service");
        intent.putExtras(bundle)
        startService(intent)
    }


//    fun main() = runBlocking<Unit> {
//            val channel = Channel<String>()
//            launch {
//                channel.send("A1")
//                channel.send("A2")
//                println("A DONE")
//            }
//            launch {
//                channel.send("B1")
//                println("B DONE")
//            }
//            launch {
//                repeat(3){
//                    val x =channel.receive()
//                    println("    X    value     $x")
//                }
//            }

//        val job = GlobalScope.launch {
//            //launch a new coroutine and keep a reference to its job
//            delay(1000L)
//            Log.e("TAG","World,   +${Thread.currentThread().name}")
//        }
//
//        job.join()
//        Log.e("TAG","Hello,   +${Thread.currentThread().name}")

//     runBlocking<Int> {
//         delay(2000L)
//         Log.e("TAG","start ") // print after delay
//         val channel = Channel<Int>()
//       val job1=GlobalScope.launch {
//             delay(1000L)
//             channel.send(1)
//             Log.e("TAG","World! 1111 + ${Thread.currentThread().name}") // print after delay
//         }
//         val job2=    GlobalScope.launch {
//             delay(1000L)
//             job1.join()
//             channel.send(2)
//
//             Log.e("TAG","World! 2222 + ${Thread.currentThread().name}") // print after delay
//         }
//         val job3=   GlobalScope.launch {
//             delay(1000L)
//             job2.join()
//             channel.send(3)
//             Log.e("TAG","World! 3333 + ${Thread.currentThread().name}") // print after delay
//         }
////         GlobalScope.launch {
////             delay(1000L)
////             channel.send(4)
////             Log.e("TAG","World!  4444 + ${Thread.currentThread().name}") // print after delay
////         }
////         GlobalScope.launch {
////             delay(1000L)
////             channel.send(5)
////             Log.e("TAG","World!  5555 + ${Thread.currentThread().name}") // print after delay
////         }
//         job3.join()
//         var temp=0
//
//         for (item in channel){
//             Log.e("TAG","value   +$item")
//
//             temp+=item
//         }
//
//         temp
//
//
//     }
//        Log.e("TAG","Hello, + ${Thread.currentThread().name}") // main thread continues while coroutine is delayed
//        Thread.sleep(2000L)


//        runBlocking {
//            println(Thread.currentThread().name)
//            val deferred: Deferred<Int> = async {
//
//
//            }
//
//
//        }


//    }


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


    class OnServiceConnection(private var myInterface: IMyAidlInterface) : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            myInterface = IMyAidlInterface.Stub.asInterface(service)


        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }

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