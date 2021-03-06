package com.example.training_4_29.model.entities.RandomUser

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RandomUserResponse {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("info")
    @Expose
    var info: Info? = null

}
