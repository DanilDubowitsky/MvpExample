package com.example.mvpexample.data.services

import com.example.mvpexample.data.model.RemoteImagesData
import io.reactivex.rxjava3.core.Single

interface IService {

    interface IImagesService : IService {
        fun loadImages(): Single<RemoteImagesData>
    }

}