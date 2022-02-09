package com.example.mvpexample.data.model

import com.google.gson.annotations.SerializedName

data class RemoteImageData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("views")
    val views: Int,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("webformatURL")
    val imageUrl: String

)