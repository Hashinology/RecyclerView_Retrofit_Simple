package com.hashinology.recyclerviewkotlinwithretrofit.models

import com.google.gson.annotations.SerializedName

data class ModelList(
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("probability")
    val probability: Double,
    @SerializedName("count")
    val count: Int
) {
}