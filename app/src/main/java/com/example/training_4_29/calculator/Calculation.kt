package com.example.training_4_29.calculator

class Calculation(val addition: Addition) {

    fun addTen(a: Int, b: Int) = addition.add(a, b) + 10
}