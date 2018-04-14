package com.project.jeremyg.mysimpleatlas.views.adapters

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import com.project.jeremyg.mysimpleatlas.repositories.models.Country
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.project.jeremyg.mysimpleatlas.R
import com.project.jeremyg.mysimpleatlas.di.modules.GlideApp
import org.androidannotations.annotations.Bean

class CountriesRecyclerViewAdapter(var context: Context) : RecyclerView.Adapter<CountriesRecyclerViewAdapter.ViewHolder>() {

    private var countries = ArrayList<Country>()

    var clickListener: onCountryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries.get(position)
        holder.name.setText(country.name)
        GlideApp
                .with(context)
                .load("file:///android_asset/" + country.thumbnail?.toLowerCase())
                .into(holder.photo)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    fun getItem(position: Int): Country {
        return countries.get(position)
    }

    fun updateData(countries: ArrayList<Country>) {
        this.countries = countries
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var photo: ImageView
        var name: TextView

        init {
            name = itemView.findViewById(R.id.c_name) as TextView
            photo = itemView.findViewById(R.id.c_image) as ImageView
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener?.onClick(view, getAdapterPosition());
        }

    }

    interface onCountryClickListener {
        fun onClick(view: View, position: Int)
    }
}