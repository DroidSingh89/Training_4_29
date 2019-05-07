package com.example.training_4_29.adapter

import android.content.ContentValues.TAG
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import com.example.training_4_29.R
import com.example.training_4_29.kotlinReview.Animal

class AnimalListAdapter(val animalList: List<Animal>) : RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_animal, parent, false)

        val viewHolder = ViewHolder(view)

        Log.d(TAG, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Position:$position ViewHolder: $viewHolder")
        val animal = animalList[position]
        viewHolder.tvAnimalType.text = animal.type
        viewHolder.tvAnimalGender.text = animal.gender
        viewHolder.tvAnimalWeight.text = animal.weight.toString()

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvAnimalType = itemView.findViewById<TextView>(R.id.tvAnimalType)
        val tvAnimalWeight = itemView.findViewById<TextView>(R.id.tvAnimalWeight)
        val tvAnimalGender = itemView.findViewById<TextView>(R.id.tvAnimalGender)

    }
}