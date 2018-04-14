package com.project.jeremyg.mysimpleatlas.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.project.jeremyg.mysimpleatlas.di.keys.ViewModelKey
import com.project.jeremyg.mysimpleatlas.viewmodels.CountriesViewModel
import com.project.jeremyg.mysimpleatlas.viewmodels.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel::class)
    abstract fun bindCountriesViewModel(countriesViewModelModel: CountriesViewModel): ViewModel

    @Binds
    abstract fun bindFactoryViewModel(factory: FactoryViewModel): ViewModelProvider.Factory
}