package com.example.training_4_29.model.entities

import com.example.training_4_29.kotlinReview.Person


fun personGenerator(size: Int): List<Person> {

    return (1..size).map { Person(listOf("John", "Mark", "David", "Jake")[it % 4], it, listOf("Male", "Female")[it % 2]) }
}