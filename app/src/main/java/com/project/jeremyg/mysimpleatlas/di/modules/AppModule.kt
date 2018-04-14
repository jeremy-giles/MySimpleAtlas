package com.project.jeremyg.mysimpleatlas.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.project.jeremyg.mysimpleatlas.repositories.remote.api.CountryWebService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = arrayOf(
        ViewModelModule::class))
class AppModule() {

    /** NETWORK INJECTION **/

    @Provides
    fun provideGson() : Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.myjson.com")
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideCountryWebService(restAdapter: Retrofit) : CountryWebService {
        return restAdapter.create(CountryWebService::class.java)
    }
}