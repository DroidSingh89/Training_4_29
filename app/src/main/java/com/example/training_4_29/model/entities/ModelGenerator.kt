package com.example.training_4_29.model.entities

import com.example.training_4_29.kotlinReview.Animal
import com.example.training_4_29.kotlinReview.Person


fun personGenerator(size: Int): List<Person> {

    return (1..size)
        .map { Person(listOf("John", "Mark", "David", "Jake")[it % 4],
        it,
        listOf("Male", "Female")[it % 2]) }
}

fun animalGenerator(size: Int): List<Animal> {

    return (1..size)
        .map { Animal(listOf("Cat", "Tiger", "Snake", "Elephant", "Giraffe", "Monkey")[it % 6],
        it,
        listOf("Male", "Female")[it % 2]) }
}