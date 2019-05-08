package com.example.applicationphil.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.applicationphil.R
import com.example.applicationphil.model.entities.Person

class PersonListAdapter(context: Context, val resource: Int, val personList: MutableList<Person>): ArrayAdapter<Person>(context, resource, personList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        view = LayoutInflater.from(context).inflate(resource, parent, false)

        val tvPersonName = view?.findViewById<TextView>(R.id.tvPersonName)
        val tvPersonAge = view?.findViewById<TextView>(R.id.tvPersonAge)
        val tvPersonGender = view?.findViewById<TextView>(R.id.tvPersonGender)

        val person = personList[position]

        // bind data to the person object
        tvPersonName?.text = person.name
        tvPersonGender?.text = person.gender
        tvPersonAge?.text = person.age.toString()

        return view
    }

    fun updatePersonList(personList: List<Person>){
        this.personList.clear()
        this.personList.addAll(personList)
        notifyDataSetChanged()
    }

}