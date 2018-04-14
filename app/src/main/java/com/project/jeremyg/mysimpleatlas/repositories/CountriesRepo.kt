package com.project.jeremyg.mysimpleatlas.repositories

import com.project.jeremyg.mysimpleatlas.repositories.models.Country
import com.project.jeremyg.mysimpleatlas.repositories.remote.api.CountryWebService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CountriesRepo @Inject constructor(countryWebService: CountryWebService) {

    private var countryWebService: CountryWebService? = countryWebService

    fun getCountries(successHandler: (MutableList<Country>) -> Unit,
                     failureHandler: (Throwable?) -> Unit) {

    }
}
