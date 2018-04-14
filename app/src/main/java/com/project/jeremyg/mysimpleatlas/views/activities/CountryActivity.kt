package com.project.jeremyg.mysimpleatlas.views.activities

import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.project.jeremyg.mysimpleatlas.R
import com.project.jeremyg.mysimpleatlas.di.modules.GlideApp
import kotlinx.android.synthetic.main.activity_country.*
import org.androidannotations.annotations.*

@EActivity(R.layout.activity_country)
class CountryActivity : AppCompatActivity() {

    @ViewById
    lateinit var photo: ImageView

    @Extra("photo")
    lateinit var flag: String

    @Extra("description")
    lateinit var information: String

    @AfterViews
    fun init() {
        GlideApp
                .with(this)
                .load("file:///android_asset/" + flag?.toLowerCase())
                .into(photo)

        description.text = information
    }
}
