package com.project.jeremyg.mysimpleatlas.views.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.project.jeremyg.mysimpleatlas.R
import com.project.jeremyg.mysimpleatlas.repositories.models.Country
import com.project.jeremyg.mysimpleatlas.viewmodels.CountriesViewModel
import com.project.jeremyg.mysimpleatlas.views.adapters.CountriesRecyclerViewAdapter
import dagger.android.support.DaggerAppCompatActivity
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.ViewById
import javax.inject.Inject

@EActivity(R.layout.activity_main)
class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    var countriesViewModel: CountriesViewModel? = null

    var countriesAdapter: CountriesRecyclerViewAdapter? = null

    @ViewById(R.id.rv_countries_list)
    protected lateinit var recyclerCountriesList: RecyclerView

    @AfterViews
    fun init() {
        initAdapter()
        initViewModel()
    }

    private fun initAdapter() {
        countriesAdapter = CountriesRecyclerViewAdapter(this)
        recyclerCountriesList?.setLayoutManager(LinearLayoutManager(this))
        recyclerCountriesList?.setAdapter(countriesAdapter)
    }

    private fun initViewModel() {
        countriesViewModel = ViewModelProviders.of(this, viewModelFactory).get(CountriesViewModel::class.java)
        countriesViewModel!!.countries.observe(this, Observer<ArrayList<Country>> { countries ->
            if(countries?.isNotEmpty()!!) {
                countriesAdapter?.updateData(countries = countries)
            }
        })
    }
}
