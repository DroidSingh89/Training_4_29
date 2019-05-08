package com.example.training_4_29.kotlinReview


//also: return object
//let : return lambda result
//apply : return object
//run: return lambda result
//with: return lambda result

fun main() {

    val numberList = mutableListOf<Double>()
    numberList.also { println("Population the list") }
        .apply {
            add(4.3)
            add(2.3)
            add(5.6)
            add(23.6)
        }
        .also{
            println("Sorting the list")
                it.sort()
        }
        .let { println(it) }

    val person = Person()
    person.name = "asdf"
    person.gender = "male"

    println(person.takeIf {  it.gender == "female"})

    person.let {
        println(it)
        it.incrementAge()
    }

    person.apply {
        println(this)
        incrementAge()
    }


    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val result = numbers.map { it * 2 }.filter { it > 4 }.let { println(it) }

//    val result1 = numbers.map { it * 2 }.filter { it > 4 }
//    println(result1)






}