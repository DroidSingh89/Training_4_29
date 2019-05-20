package com.example.applicationphil.adapter

import android.content.ContentValues.TAG
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.applicationphil.R
import com.example.applicationphil.model.entities.Animal

class AnimalListAdapter(val animalList: List<Animal>): androidx.recyclerview.widget.RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_animal, parent, false)

        val viewHolder = ViewHolder(view)

        Log.d(TAG, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Position $position, ViewHolder $viewHolder")
        val animal = animalList[position]
        viewHolder.tvAnimalType.text = animal.type
        viewHolder.tvAnimalWeight.text = animal.weight.toString()
        viewHolder.tvAnimalGender.text = animal.gender
    }

    class ViewHolder(itemView: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        val tvAnimalType = itemView.findViewById<TextView>(R.id.tvAnimalType)
        val tvAnimalWeight = itemView.findViewById<TextView>(R.id.tvAnimalWeight)
        val tvAnimalGender = itemView.findViewById<TextView>(R.id.tvAnimalGender)

    }

}