package com.example.mvpexample.di.service

import com.example.mvpexample.data.services.IService
import com.example.mvpexample.data.services.ImagesService
import dagger.Binds
import dagger.Module

@Module
abstract class ServiceModule {

    @Binds
    abstract fun bindImageService(service: ImagesService): IService.IImagesService

}