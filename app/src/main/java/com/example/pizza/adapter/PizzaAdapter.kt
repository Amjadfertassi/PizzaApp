package com.example.pizza.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pizza.R
import com.example.pizza.classes.Pizza

class PizzaAdapter(activity: Activity, pizzas: List<Pizza>) :
    BaseAdapter() {
    private val pizzas: List<Pizza>
    private val inflater: LayoutInflater

    init {
        this.pizzas = pizzas
        inflater =
            activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return pizzas.size
    }

    override fun getItem(i: Int): Any {
        return pizzas[i]
    }

    override fun getItemId(p0: Int): Long {
        return pizzas[p0].id.toLong()
    }

    override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
// val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item_pizza, null);
        val nom = view.findViewById<TextView>(R.id.nom)
        val ingredients = view.findViewById<TextView>(R.id.ingredients)
        val duration = view.findViewById<TextView>(R.id.duration)
        val id = view.findViewById<TextView>(R.id.id)
        val image = view.findViewById<ImageView>(R.id.image)
        nom.text = pizzas[i].nom
        ingredients.text = pizzas[i].nbrIngredients.toString()
        duration.text = pizzas[i].duree.toString()
        id.text = pizzas[i].id.toString()
        image.setImageResource(pizzas[i].photo)
        return view
    }
}