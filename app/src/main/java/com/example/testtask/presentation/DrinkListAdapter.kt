package com.example.testtask.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.domain.Drink
import com.squareup.picasso.Picasso

class DrinkListAdapter(private val coffeeList: List<Drink>) :
    RecyclerView.Adapter<DrinkListAdapter.CoffeeListViewHolder>() {

    class CoffeeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.drink_list_item, parent, false)
        return CoffeeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeListViewHolder, position: Int) {
        val coffeeItem = coffeeList[position]
        with(holder) {
            title.text = coffeeItem.title
            description.text = coffeeItem.description.split(".")[0]
            Picasso.get().load(coffeeItem.image).into(image)
        }
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }

}