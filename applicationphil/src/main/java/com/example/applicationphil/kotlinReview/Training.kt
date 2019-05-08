package com.example.applicationphil.kotlinReview

fun main() {

    var mutableString = "mutableString"
    val immutableString = "immutableString"

    var mutableInt = 10

    println(mutableString)

    // ? is used to allow null values
    var nullString: String? = null

    // ? is used to make a safe call on a value that might be null; ?: provides behaviour for null value
    println(nullString?.length ?: 0)

    // !! operator is used to make an unsafe call on a nullable type
    //println(nullString!!.length)

    println(addNumber(3, 4))
}

// Creating my first function
fun addNumber(a:Int, b:Int):Int = a+b

