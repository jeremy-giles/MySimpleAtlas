package com.project.jeremyg.mysimpleatlas.di.components

import com.project.jeremyg.mysimpleatlas.di.modules.ViewModelModule
import com.project.jeremyg.mysimpleatlas.viewmodels.CountriesViewModel
import dagger.Component

@Component(modules = arrayOf(
        ViewModelModule::class)
)
interface ViewModelComponent {
    fun inject(countriesViewModel: CountriesViewModel)
}