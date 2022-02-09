package com.example.mvpexample.data.services

import com.example.mvpexample.data.api.ImagesApi
import com.example.mvpexample.data.model.RemoteImagesData
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ImagesService @Inject constructor(
    private val imagesNetworkApi: ImagesApi
) : IService.IImagesService {

    override fun loadImages(): Single<RemoteImagesData> {
        return imagesNetworkApi.getImages()
    }

}