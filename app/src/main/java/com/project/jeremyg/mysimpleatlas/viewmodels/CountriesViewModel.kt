package com.project.jeremyg.mysimpleatlas.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.jeremyg.mysimpleatlas.repositories.models.Country

class CountriesViewModel : ViewModel() {

    var countries = MutableLiveData<List<Country>>()
}