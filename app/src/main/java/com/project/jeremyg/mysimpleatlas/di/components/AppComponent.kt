package com.project.jeremyg.mysimpleatlas.di.components

import android.app.Application
import com.project.jeremyg.mysimpleatlas.di.modules.ActivityModule
import com.project.jeremyg.mysimpleatlas.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
                        AppModule::class,
                        ActivityModule::class))
interface AppComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}