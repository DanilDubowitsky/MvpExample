package com.example.mvpexample.data.model

import com.google.gson.annotations.SerializedName

data class RemoteImagesData(
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int,
    @SerializedName("hits")
    val hits: List<RemoteImageData>
)

