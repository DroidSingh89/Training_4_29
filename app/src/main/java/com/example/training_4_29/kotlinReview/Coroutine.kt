package com.example.training_4_29.kotlinReview

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun sampleSuspend() = withContext(Dispatchers.IO) {
    delay(1000)
    println("<top>.sampleSuspend")
}

fun runSuspendingFunctions(block: suspend () -> Unit) {
    GlobalScope.launch {
        block()
    }
}


fun main() {

    val time =measureTimeMillis {
        runSuspendingFunctions {
            sampleSuspend()
        }
    }
    print(time)
    Thread.sleep(2000)
}