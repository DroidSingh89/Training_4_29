package com.example.applicationphil.model.entities

import kotlin.random.Random

fun personGenerator(size: Int): MutableList<Person>{

    return (1..size).map{
        Person(
            name = listOf("John", "Mark", "David", "Jake", "Mary", "Sue", "Jen")[Random.nextInt(7) % 7],
            age = it,
            gender = listOf("Male", "Female")[it % 2]
        )
    }.toMutableList()
}

fun animalGenerator(size: Int): MutableList<Animal> {

    return (1..size).map{
        Animal(
            type = listOf(
                "Lion",
                "Tiger",
                "Aardvark",
                "Honey Badger",
                "Honey Bee",
                "Ant",
                "Antlion"
            )[Random.nextInt(7) % 7],
            weight = it,
            gender = listOf("Male", "Female")[it % 2]
        )
    }.toMutableList()

}