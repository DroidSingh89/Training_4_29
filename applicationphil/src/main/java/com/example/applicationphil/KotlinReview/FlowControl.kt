package com.example.applicationphil.KotlinReview

fun main() {
    println(testWhen(30))
    println(testWhen(10))
    println(testWhen(3))
    println(testWhen(-3))
    println(testWhen(100))

    println(testIfElse(3))
    println(testIfElse(13))

    testForEach(1..10)

    var a = arrayOf(1,2,3,4)
    (1..(a.size)).forEach({println(it)})

    val immutableList = listOf(1,2,3,4)
    testFor(immutableList)
    val mutableList = mutableListOf(1,2,3,4)
    testFor(mutableList)
    mutableList.add(5)
    testFor(mutableList)


}

fun testWhen(value:Int):String{

    return "$value: " + when(value){
        in -10..0 -> "Number negative, more than -10"
        in 1..9 -> "Number positive, less than 10"
        in 10..50 -> "Number positive, in 10 to 50"
        else -> "Out of range"
    }

}

fun testIfElse(value:Int):String = if(value>10) "greater than 10" else "less than 10"

fun testForEach(range:IntRange) = range.forEach({ x:Int -> println(x) })

fun testFor(list: List<Int>){
    for(i in list){
        println(i)
    }
}