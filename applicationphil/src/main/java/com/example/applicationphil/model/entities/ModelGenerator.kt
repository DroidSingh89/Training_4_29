package com.example.applicationphil.model.entities

import com.example.applicationphil.KotlinReview.Person
import kotlin.random.Random

fun personGenerator(size: Int): List<Person>{

    return (1..size).map{ Person(
        name = listOf("John", "Mark", "David", "Jake", "Mary", "Sue", "Jen")[Random.nextInt(7)-1],
        age = it,
        gender = listOf("Male", "Female")[it % 2]) }

}