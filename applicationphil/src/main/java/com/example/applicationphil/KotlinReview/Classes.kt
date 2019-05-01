package com.example.applicationphil.KotlinReview


fun main() {

    val john = Person("John Doe", 30, "Male")
    val mark = Person(age = 30, name = "Mark Doe", gender = "Male")
    val julia = Person(age = 30, name = "Julia")
    println(john.toString())

    val cat = Animal("Cat", 8, "Male")
    println(cat.checkType())
    println(cat)
    println(cat.safeType)

    val phil = AndroidDeveloper("Mobile Apps", "Phil Bascom")
    println("Name: ${phil.name}, Company: ${phil.company}")
}


open class Person(name:String = "John", age:Int = 30, gender:String = "Female"){
    var name: String = name
    get() = "Name: $field"

    var age: Int = age
    get() = field+2

    var gender: String = ""
    init {
        this.gender = gender
    }

    fun incrementAge() = age++
}

data class Animal(val type:String, val weight:Int, val gender:String){

    val safeType:String
    get() = "Type: $type"

    override fun toString(): String {
        return "MyFormat: Type ${type}, Weight ${weight}, Gender ${gender}"
    }

    fun checkType():String = if(type.equals("Cat")) "Is a cat" else "Is not a cat"
}

class AndroidDeveloper(val company: String, name:String): Person(name = name, gender = "Male"){

}

object Zoo{
    val Cat = Animal("Cat", 8, "Female")
    val Tiger = Animal("Cat", 800, "Female")
}