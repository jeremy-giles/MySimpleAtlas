package com.project.jeremyg.mysimpleatlas.di.modules

import com.project.jeremyg.mysimpleatlas.views.activities.MainActivity
import com.project.jeremyg.mysimpleatlas.views.activities.MainActivity_
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jeremy on 14/04/2018.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity_

}