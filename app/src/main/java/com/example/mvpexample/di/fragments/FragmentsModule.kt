package com.example.mvpexample.di.fragments

import com.example.mvpexample.di.fragments.main.MainScreenModule
import com.example.mvpexample.ui.fragments.main.MainScreenFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = [MainScreenModule::class])
    abstract fun mainScreenFragment(): MainScreenFragment

}