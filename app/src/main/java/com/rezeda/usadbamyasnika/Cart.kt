package com.rezeda.usadbamyasnika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val house = findViewById<LinearLayout>(R.id.house)
        val catalog = findViewById<LinearLayout>(R.id.catalog)
        val cart = findViewById<LinearLayout>(R.id.cart)
        val recept = findViewById<LinearLayout>(R.id.recept)
        val profile = findViewById<LinearLayout>(R.id.profile)

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
    }
}