package com.example.training_4_29.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.training_4_29.R
import com.example.training_4_29.kotlinReview.Person

class PersonListAdapter(context: Context, val resource: Int, val personList: List<Person>): ArrayAdapter<Person>(context, resource, personList) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        view = LayoutInflater.from(context).inflate(resource, parent, false)

        val tvPersonName = view.findViewById<TextView>(R.id.tvPersonName)
        val tvPersonAge = view.findViewById<TextView>(R.id.tvPersonAge)
        val tvPersonGender = view.findViewById<TextView>(R.id.tvPersonGender)

        val person = personList[position]

//        bind the data to the person object
        tvPersonName.text = person.name
        tvPersonGender.text = person.gender
        tvPersonAge.text = person.age.toString()

        return view
    }


}