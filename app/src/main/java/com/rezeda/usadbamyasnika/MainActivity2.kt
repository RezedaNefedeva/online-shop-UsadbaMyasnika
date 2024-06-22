package com.rezeda.usadbamyasnika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {

    lateinit var bottom_nav_menu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bottom_nav_menu = findViewById(R.id.bottom_nav_menu) as BottomNavigationView

        val navController = findNavController(R.id.fragmentContainerView)

        bottom_nav_menu.setupWithNavController(navController)

        val database = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/")
        val table = database.getReference("Product")

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.mainFragment -> bottom_nav_menu.menu.findItem(R.id.menu_house).isChecked = true
                R.id.catalogFragment -> bottom_nav_menu.menu.findItem(R.id.menu_catalog).isChecked = true
                R.id.categoryFragment -> bottom_nav_menu.menu.findItem(R.id.menu_catalog).isChecked = true
                R.id.cartFragment -> bottom_nav_menu.menu.findItem(R.id.menu_cart).isChecked = true
                R.id.receptFragment -> bottom_nav_menu.menu.findItem(R.id.menu_recept).isChecked = true
                R.id.profileFragment -> bottom_nav_menu.menu.findItem(R.id.menu_profile).isChecked = true
                R.id.regFragment -> bottom_nav_menu.menu.findItem(R.id.menu_profile).isChecked = true
            }
        }
        bottom_nav_menu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_house -> {
                    navController.navigate(R.id.mainFragment)
                    true
                }
                R.id.menu_catalog ->{
                    navController.navigate(R.id.catalogFragment)
                    true
                }
                R.id.menu_cart ->{
                    navController.navigate(R.id.cartFragment)
                    true
                }
                R.id.menu_recept ->{
                    navController.navigate(R.id.receptFragment)
                    true
                }
                else -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
            }
        }

    }
}