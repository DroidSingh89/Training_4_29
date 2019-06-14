package com.example.training_4_29.kotlinReview

import com.example.training_4_29.model.entities.Animal
import com.example.training_4_29.model.entities.Person

fun main() {

    val john = Person("John Doe", 10, "Male")
    val mark = Person(age = 30, name = "Mark", gender = "Male")
    val julia = Person("Julia", 14)

    println(john.toString())
    println(john.name)

    val cat = Animal("Cat", 30, "Male")
    println(cat.checkType())
    println(cat.toString())
    println(cat.safeType)

    val phil = AndroidDeveloper("Mobile Apps", "Phil")
    println("${phil.name}, Company:${phil.company}")

}




class AndroidDeveloper(val company: String, name: String) : Person(name = name)