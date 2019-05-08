package com.example.training_4_29.model.entities


fun personGenerator(size: Int): MutableList<Person> {

    return (1..size)
        .map { Person(listOf("John", "Mark", "David", "Jake")[it % 4],
        it,
        mutableListOf("Male", "Female")[it % 2]) }.toMutableList()
}

fun animalGenerator(size: Int): MutableList<Animal> {

    return (1..size)
        .map { Animal(
            mutableListOf("Cat", "Tiger", "Snake", "Elephant", "Giraffe", "Monkey")[it % 6],
        it,
        mutableListOf("Male", "Female")[it % 2]) }.toMutableList()
}
