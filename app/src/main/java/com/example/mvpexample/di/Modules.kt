package com.example.mvpexample.di

import com.example.mvpexample.ui.activities.MainActivity
import com.example.mvpexample.di.fragments.FragmentsModule
import com.example.mvpexample.di.network.NetworkModule
import com.example.mvpexample.di.service.ServiceModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        FragmentsModule::class,
        NetworkModule::class,
        ServiceModule::class
    ]
)
abstract class Modules {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}