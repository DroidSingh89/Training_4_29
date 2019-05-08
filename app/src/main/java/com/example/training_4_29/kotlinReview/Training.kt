package com.example.training_4_29.kotlinReview


fun main() {

    var mutableString = "mutableString"
    val immutableString = "immutableString"

    var mutableInt = 10

    println(mutableString)


    //? is used for making the variable null
    var nullableValue: String? = null

    //?. is used to make the safe call, ?: elvis operator is used for a default value
    println(nullableValue?.length ?: 0)

    //!! enforces the compiler to not make a safe call on nullable type
    //println(nullableValue!!.length)


    println(addNumber(3,4))
}


//creating your first function
fun addNumber(a:Int, b:Int):Int = a+b

