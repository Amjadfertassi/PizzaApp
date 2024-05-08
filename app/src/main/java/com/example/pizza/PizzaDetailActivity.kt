package com.example.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.example.pizza.R
import com.example.pizza.classes.Pizza
import com.example.pizza.service.PizzaService

class PizzaDetailActivity : AppCompatActivity() {

    lateinit var pizza_name: TextView
    lateinit var description: TextView
    lateinit var ingredient: TextView
    lateinit var image: ImageView
    lateinit var ps: PizzaService
    lateinit var prep: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)
        image = findViewById(R.id.imageView5)
        pizza_name = findViewById(R.id.pizza_name)
        description = findViewById(R.id.description)
        ingredient = findViewById(R.id.ingredient)
        prep = findViewById(R.id.preparation)
        val intent = intent
        ps = PizzaService.instance!!
        val idString: String? = intent.getStringExtra("id")
        val id: Int = idString?.toIntOrNull() ?: 0  // Default to 0 if idString is null or not a valid integer
        val p: Pizza? = ps.findById(id)
        if (p != null) {
            pizza_name.text = p.nom
            image.setImageResource(p.photo)
            description.text = p.description
            ingredient.text = p.detailsIngred
            prep.text = p.preparation
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                shareApp()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun shareApp() {
        val msg: String = "hi there, checkout these cool recipes"
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, msg)
        intent.type = "text/plain"
        startActivity(intent)
    }
}