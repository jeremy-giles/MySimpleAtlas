package com.project.jeremyg.mysimpleatlas.repositories.remote.api

import android.arch.lifecycle.LiveData
import com.project.jeremyg.mysimpleatlas.repositories.models.Country
import retrofit2.http.GET


interface CountryWebService {

    /**
        https://api.myjson.com/bins/w0lnz
     */
    @GET("/bins/w0lnz")
    fun getCountries(): LiveData<Country>

}