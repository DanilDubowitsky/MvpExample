package com.example.mvpexample.data.api

import com.example.mvpexample.data.model.RemoteImagesData
import com.example.mvpexample.di.network.NetworkModule.Companion.API_KEY
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("api/$API_KEY")
    fun getImages(
        @Query("page") pageNumber: Int,
        @Query("per_page") perPage: Int = 20
    ): Single<RemoteImagesData>

}