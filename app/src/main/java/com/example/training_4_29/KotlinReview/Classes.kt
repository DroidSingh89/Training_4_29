package com.example.training_4_29.KotlinReview

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


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


open class Person(name: String = "John", age: Int=30, gender: String = "Female"): Serializable {
    var age: Int = age
    var name: String = name
    //    get() = "Name:$field"
    var gender: String? = null

    init {
        this.gender = gender
    }

    fun incrementAge() = age++
    override fun toString(): String {
        return "Person(age=$age, name='$name', gender=$gender)"
    }


}

data class Animal(val type: String, val weight: Int, val gender: String) : Parcelable{

    val safeType: String
        get() = "Type:$type"

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun toString(): String {
        return "MyAnimalFormat=(Type=$type, Weight=$weight, Gender=$gender)"
    }

    fun checkType(): String = if (type == "Cat") "Is a cat" else "Is not a cat"

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeInt(weight)
        parcel.writeString(gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Animal> {
        override fun createFromParcel(parcel: Parcel): Animal {
            return Animal(parcel)
        }

        override fun newArray(size: Int): Array<Animal?> {
            return arrayOfNulls(size)
        }
    }

}

class AndroidDeveloper(val company: String, name: String) : Person(name = name)