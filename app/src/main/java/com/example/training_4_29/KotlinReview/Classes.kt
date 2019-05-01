package com.example.training_4_29.KotlinReview


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


open class Person(name: String = "John", age: Int=30, gender: String = "Female") {
    val name: String = name
        get() = "Name:$field"
    var gender: String? = null

    init {
        this.gender = gender
    }
}

data class Animal(val type: String, val weight: Int, val gender: String) {

    val safeType: String
        get() = "Type:$type"

    override fun toString(): String {
        return "MyAnimalFormat=(Type=$type, Weight=$weight, Gender=$gender)"
    }

    fun checkType(): String = if (type == "Cat") "Is a cat" else "Is not a cat"

}

class AndroidDeveloper(val company: String, name: String) : Person(name = name)