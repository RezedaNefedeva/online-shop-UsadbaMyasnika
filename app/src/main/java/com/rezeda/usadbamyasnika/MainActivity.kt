package com.rezeda.usadbamyasnika

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.helpers.ReceptAdapter
import com.rezeda.usadbamyasnika.models.Recept

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recepts: RecyclerView = findViewById(R.id.recept_list)
        val receptList = arrayListOf<Recept>()
        receptList.add(Recept(1, "pic1", "Рецепт 1", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))
        receptList.add(Recept(1, "pic1", "Рецепт 2", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))
        receptList.add(Recept(1, "pic1", "Рецепт 3", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))
        receptList.add(Recept(1, "pic1", "Рецепт 4", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))

        recepts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recepts.adapter = ReceptAdapter(receptList, this)

        val house = findViewById<LinearLayout>(R.id.house)
        val catalog = findViewById<LinearLayout>(R.id.catalog)
        val cart = findViewById<LinearLayout>(R.id.cart)
        val recept = findViewById<LinearLayout>(R.id.recept)
        val profile = findViewById<LinearLayout>(R.id.profile)
        val btn_catalog = findViewById<Button>(R.id.btn_catalog)
        val btn_all_recepts = findViewById<Button>(R.id.btn_all_recepts)

        house.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        catalog.setOnClickListener {
            startActivity(Intent(this, Catalog::class.java))
        }

        cart.setOnClickListener {
            startActivity(Intent(this, Cart::class.java))
        }

        recept.setOnClickListener {
            startActivity(Intent(this, ReceptsPage::class.java))
        }

        profile.setOnClickListener {
            startActivity(Intent(this, UserPage::class.java))
        }

        btn_catalog.setOnClickListener {
            startActivity(Intent(this, Catalog::class.java))
        }

        btn_all_recepts.setOnClickListener {
            startActivity(Intent(this, ReceptsPage::class.java))
        }

    }
}