package com.example.training_4_29.movieDb.model.entities.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Genre {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}
