package com.example.mvpexample.di

import com.example.mvpexample.App
import com.example.mvpexample.di.fragments.FragmentsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        Modules::class,
        FragmentsModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App?)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindInstance(app: App): Builder

        fun build(): AppComponent

    }

}