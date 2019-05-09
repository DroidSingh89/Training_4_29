package com.example.training_4_29.model.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

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


//use the class for room
@Entity(tableName = "animal")
data class Animal(@ColumnInfo(name = "type") var type: String = "Cat",
                  @ColumnInfo(name = "weight")var weight: Int = 50,
                  @ColumnInfo(name = "gender")var gender: String = "Female") : Parcelable {


    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


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


data class Contact(val name: String, val numbers: List<String>)