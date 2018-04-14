package com.project.jeremyg.mysimpleatlas.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.jeremyg.mysimpleatlas.repositories.CountriesRepo
import com.project.jeremyg.mysimpleatlas.repositories.models.Country
import javax.inject.Inject

class CountriesViewModel() : ViewModel() {

    lateinit var countriesRepo: CountriesRepo

    var countries = MutableLiveData<List<Country>>()

    @Inject
    constructor(countriesRepo: CountriesRepo) : this() {
        this.countriesRepo = countriesRepo
        init()
    }

    private fun init() {
        getCountriesList()
    }

    private fun getCountriesList() {
        countriesRepo.getCountries(
                {
                    countries.value = it
                },{
                    //apiError.value = it
                })
    }
}