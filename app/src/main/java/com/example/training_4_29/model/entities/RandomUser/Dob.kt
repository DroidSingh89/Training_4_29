package com.example.training_4_29.model.entities.RandomUser

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Dob {

    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("age")
    @Expose
    var age: Int? = null

}
