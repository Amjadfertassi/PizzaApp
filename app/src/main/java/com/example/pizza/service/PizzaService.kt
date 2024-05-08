package com.example.pizza.service


import com.example.pizza.R
import com.example.pizza.classes.Pizza
import com.example.pizza.dao.IDao
class PizzaService private constructor() : IDao<Pizza> {
    private val pizzas: MutableList<Pizza>

    init {
        pizzas = ArrayList()

        // Adding sample pizzas for testing
        pizzas.add(
            Pizza(
                "Pizza Margherita",
                5,
                R.drawable.pizza_sliders,
                30,
                "Tomato, Mozzarella, Basil",
                "Classic Margherita Pizza",
                "Preheat the oven to 475°F (245°C). Place the pizza in the oven and bake until the crust is golden and the cheese is bubbly and browned."
            )
        )

        pizzas.add(
            Pizza(
                "Pepperoni Pizza",
                7,
                R.drawable.pizza_pepperoni,
                25,
                "Tomato, Mozzarella, Pepperoni",
                "Spicy Pepperoni Pizza",
                "Preheat the oven to 450°F (230°C). Top with pepperoni and bake until the crust is golden and the cheese is melted and slightly browned."
            )
        )
        pizzas.add(
            Pizza(
                "Pepper Pizza",
                7,
                R.drawable.pizza_pepper,
                20,
                "Tomato, Mozzarella, Pepper",
                "Spicy Pepperoni Pizza",
                "Preheat the oven to 450°F (230°C). Top with pepperoni and bake until the crust is golden and the cheese is melted and slightly browned."
            )
        )
        pizzas.add(
            Pizza(
                "Chicken bbq Pizza",
                7,
                R.drawable.pizza_bbq_chicken,
                20,
                "bbq, Mozzarella, Chicken",
                "Delicious Chicken Pizza",
                "Preheat the oven to 450°F (230°C). Top with pepperoni and bake until the crust is golden and the cheese is melted and slightly browned."
            )
        )
        pizzas.add(
            Pizza(
                "Mexican Pizza",
                7,
                R.drawable.pizza_mexican,
                35,
                "Tomato, Mozzarella, Pepperoni",
                "Spicy Pepperoni Pizza",
                "Preheat the oven to 450°F (230°C). Top with pepperoni and bake until the crust is golden and the cheese is melted and slightly browned."
            )
        )

    }

    override fun create(o: Pizza): Boolean {
        return pizzas.add(o)
    }

    override fun delete(o: Pizza): Boolean {
        return pizzas.remove(o)
    }

    override fun update(o: Pizza): Boolean {
        for (p in pizzas) {
            if (p.id == o.id) {
                p.nom = o.nom
                p.description = o.description
                p.detailsIngred = o.detailsIngred
                p.duree = o.duree
                p.photo = o.photo
                p.nbrIngredients = o.nbrIngredients
                p.preparation = o.preparation
                return true
            }
        }
        return false
    }
    override fun findById(id: Int): Pizza? {
        for (p in pizzas) {
            if (p.id == id) {
                return p
            }
        }
        return null
    }
    override fun findAll(): List<Pizza> {
        return pizzas
    }
    companion object {
        var instance: PizzaService? = null
            get() {
                if (field == null) field = PizzaService()
                return field
            }
            private set
    }
}