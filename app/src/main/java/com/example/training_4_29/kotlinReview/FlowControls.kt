package com.example.training_4_29.kotlinReview


fun main() {

//    testing when expression
    println(testWhen(30))
    println(testWhen(10))
    println(testWhen(-3))

//    testing if else
    println(testIfElse(20))

//    testing for loop
    println(testForEach(1..10))


    val immutableList = listOf(1,2,3,3)
    testFor(immutableList)
    val mutableList = mutableListOf(1,2,3,4)
    testFor(mutableList)
    mutableList.add(5)
    testFor(mutableList)

}

fun testWhen(value: Int): String {

    return "$value: " + when (value) {
        //is Int -> "Is of Int type"
        in -10..0 -> "Number Negative, more than -10"
        in 1..9 -> "Number positive, less than 10"
        in 10..50 -> "Number positive in 10 to 50"
        else -> "Out of range"
    }
}

fun testIfElse(value: Int): String =
    if (value > 10) "greater than 10" else "less than 10"


fun testForEach(range: IntRange) = range.forEach { x: Int -> println(x) }

fun testFor(list: List<Int>){
    for (i in list) {
        println(i)
    }
}


