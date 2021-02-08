package com.lgw.android.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.common.utils.L

class MainActivity : AppCompatActivity() {

//    private var lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        lifecycleRegistry.currentState = Lifecycle.State.CREATED

//        GlobalScope.launch(Dispatchers.Main) {
//            withContext(Dispatchers.IO) {
//                println(Thread.currentThread().name)
//                val list = arrayListOf<Shoe>()
//                val shoe1 = Shoe("dunk 1", "Fashion shoe", 3200F, "NICK", "http://******.jpg")
//                val shoe2 = Shoe("dunk 2", "Fashion shoe", 3200F, "NICK", "http://******.jpg")
//                val shoe3 = Shoe("dunk 3", "Fashion shoe", 3200F, "NICK", "http://******.jpg")
//                val shoe4 = Shoe("dunk 4", "Fashion shoe", 3200F, "NICK", "http://******.jpg")
//                val shoe5 = Shoe("dunk 5", "Fashion shoe", 3200F, "NICK", "http://******.jpg")
//                val shoe6 = Shoe(name = "dunk 5", description = "Fashion shoe", price = 3200F, brand = "NICK", imageUrl = "http://******.jpg")
//                list.add(shoe1)
//                list.add(shoe2)
//                list.add(shoe3)
//                list.add(shoe4)
//                list.add(shoe5)

//                val shoeDaoRepository = RepositoryProvider.createShoeRepository(applicationContext)
//                shoeDaoRepository.insertShoes(list)
//                shoeDaoRepository.insertShoe(shoe1)
//                shoeDaoRepository.insertShoe(shoe2)
//                shoeDaoRepository.insertShoe(shoe3)
//                shoeDaoRepository.insertShoe(shoe4)
//                shoeDaoRepository.insertShoe(shoe5)

//                println(shoeDaoRepository.getShoeById(1).toString())
//                shoe1.id=2
//                shoe1.brand = "ADIDAS"
//                shoeDaoRepository.updateShoe(shoe1)

//                shoeDaoRepository.deleteShoe(shoe1)
//
//                println("${shoeDaoRepository.updateShoe(shoe5)}")
//                shoeDaoRepository.deleteShoe(shoe)
//                println("${shoeDaoRepository.getAllShoes()}")

//            }
//        }
    }


//    override fun getLifecycle(): Lifecycle {
//        return lifecycleRegistry
//    }
}