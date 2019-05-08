package com.example.applicationphil.kotlinReview

import com.example.applicationphil.model.entities.Person

//also: returns object
//let : returns lambda
//apply : returns object
//run: return lambda result
//with: return lambda result

fun main() {

    val person = Person()
    person.name = "Paul"
    person.gender = "Male"

    person.let {
        print(it)
        it.incrementAge()
    }

    person.apply {
        println(this)
        incrementAge()
    }

    val numbers = mutableListOf(1,2,3,4,5)
    val result = numbers.map {it*2}.filter {it>4}.let{println(it)}
    numbers.let{println(it)}

    val numberList = mutableListOf<Double>()
    numberList.also{println("Populating List")}
        .apply{
            add(23.6)
            add(2.3)
            add(7.8)
            add(4.3)
        }
        .also{
            println("Sorting List")
        }
        .apply{sort()}
        .let{println(it)}


}