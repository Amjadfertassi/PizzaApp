package com.example.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import com.example.pizza.PizzaDetailActivity
import com.example.pizza.adapter.PizzaAdapter
import com.example.pizza.service.PizzaService

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var fs: PizzaService
    private lateinit var liste: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fs = PizzaService.instance!!
//        Log.d("Liste", fs.findAll().toString())
        liste = findViewById(R.id.listview)
        
//        Log.d("Liste", fs.findAll().toString());
        liste.adapter = PizzaAdapter(this, fs.findAll())
        liste.onItemClickListener = this
        Log.d("ListSize", "Size: ${fs.findAll().size}")

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out these cool recipes!!!")
        intent.putExtra(Intent.EXTRA_TEXT, "The apps link's here....")
        startActivity(Intent.createChooser(intent, "Share via"))
        return super.onOptionsItemSelected(item)
    }
    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        val id = view.findViewById<TextView>(R.id.id)
        val intent = Intent(this, PizzaDetailActivity::class.java)
//intent.putExtra("Description",id.getText());
        intent.putExtra("id", id.text)
        startActivity(intent)
    }
}