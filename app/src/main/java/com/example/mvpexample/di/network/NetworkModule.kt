package com.example.mvpexample.di.network

import com.example.mvpexample.data.api.ImagesApi
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): ImagesApi = retrofit.create(ImagesApi::class.java)

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val API_KEY = "?key=25597156-67eb21c92311aaa3674b45892"
        const val BASE_URL = "https://pixabay.com/"
    }

}