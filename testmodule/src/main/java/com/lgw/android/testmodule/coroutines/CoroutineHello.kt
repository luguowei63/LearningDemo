package com.lgw.android.testmodule.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *Created by lgw on 3/8/21
 */
class CoroutineHello {


    fun main() = runBlocking<Unit> {
        val channel = Channel<String>()
        launch {
            channel.send("A1")
            channel.send("A2")
            println("A DONE")
        }
        launch {
            channel.send("B1")
            println("B DONE")
        }
        launch {
           repeat(3){
               val x =channel.receive()
               println(x)
           }
        }

    }


}