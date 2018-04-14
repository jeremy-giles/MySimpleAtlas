package com.project.jeremyg.mysimpleatlas

import com.project.jeremyg.mysimpleatlas.di.components.DaggerAppComponent
import dagger.android.support.DaggerApplication
import dagger.android.AndroidInjector

class MySimpleAtlasApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}