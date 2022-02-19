package com.example.mvpexample.data.usecase

import com.example.mvpexample.data.model.RemoteImageData
import com.example.mvpexample.data.services.IService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val imagesService: IService.IImagesService
) {
    operator fun invoke(pageNumber: Int): Single<List<RemoteImageData>> =
        imagesService.loadImages(pageNumber).map { remoteData ->
            remoteData.hits
        }
}