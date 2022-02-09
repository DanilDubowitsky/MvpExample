package com.example.mvpexample.di.fragments.main

import com.example.mvpexample.ui.fragments.main.ImagesRecyclerAdapter
import com.example.mvpexample.ui.fragments.main.MainScreenContract
import com.example.mvpexample.ui.fragments.main.MainScreenFragment
import com.example.mvpexample.ui.fragments.main.MainScreenPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainScreenModule {

    @Binds
    abstract fun bindView(view: MainScreenFragment): MainScreenContract.IView

    @Binds
    abstract fun bindPresenter(presenter: MainScreenPresenter): MainScreenContract.IPresenter

    @Binds
    abstract fun bindImageAdapter(adapter: ImagesRecyclerAdapter): MainScreenContract.ImagesRecyclerAdapter

    @Binds
    abstract fun bindHolderController(controller: MainScreenFragment): MainScreenContract.IHolderController

}