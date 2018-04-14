package com.project.jeremyg.mysimpleatlas.repositories

import android.util.Log
import com.project.jeremyg.mysimpleatlas.repositories.models.Country
import com.project.jeremyg.mysimpleatlas.repositories.remote.api.CountryWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesRepo @Inject constructor(countryWebService: CountryWebService) {

    private var countryWebService: CountryWebService? = countryWebService

    fun getCountries(successHandler: (ArrayList<Country>) -> Unit,
                     failureHandler: (Throwable?) -> Unit) {

        countryWebService?.getCountries()?.enqueue(
                object : Callback<ArrayList<Country>> {
                    override fun onResponse(call: Call<ArrayList<Country>>?,
                                            response: Response<ArrayList<Country>>?) {
                        Log.e("TAG", "reponse: " + response?.body())
                        successHandler(response?.body()!!)
                    }

                    override fun onFailure(call: Call<ArrayList<Country>>?, t: Throwable?) {

                    }
                })
    }
}
