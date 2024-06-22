package com.rezeda.usadbamyasnika

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.helpers.ReceptAdapter
import com.rezeda.usadbamyasnika.models.Recept
import java.io.BufferedReader

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_catalog = view.findViewById<Button>(R.id.btn_catalog)
        btn_catalog.setOnClickListener { findNavController().navigate(R.id.action_mainFragment_to_catalogFragment) }

        val btn_all_recepts = view.findViewById<Button>(R.id.btn_all_recepts)
        btn_all_recepts.setOnClickListener { findNavController().navigate(R.id.action_mainFragment_to_receptFragment) }

        val main_category_kolbasa = view.findViewById<LinearLayout>(R.id.main_category_koldasa)
        val main_category_meat = view.findViewById<LinearLayout>(R.id.main_category_meat)
        val main_category_delicates = view.findViewById<LinearLayout>(R.id.main_category_delicates)
        val main_category_zamorozka = view.findViewById<LinearLayout>(R.id.main_category_zamorozka)

        main_category_kolbasa.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_categoryFragment)
            CategoryFragment.category_name = "kolbasa"
        }

        main_category_meat.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_categoryFragment)
            CategoryFragment.category_name = "meat"
        }

        main_category_delicates.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_categoryFragment)
            CategoryFragment.category_name = "delicates"
        }

        main_category_zamorozka.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_categoryFragment)
            CategoryFragment.category_name = "zamorozka"
        }


        val recepts: RecyclerView = view.findViewById(R.id.recept_list)
        val receptList = arrayListOf<Recept>()
        receptList.add(Recept(1, "pic1", "Рецепт 1", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))
        receptList.add(Recept(2, "pic2", "Рецепт 2", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))
        receptList.add(Recept(3, "pic3", "Рецепт 3", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))
        receptList.add(Recept(4, "pic4", "Рецепт 4", "Рецепт вкусного блюда из нашей продукции", "Здесь сам рецепт"))

        recepts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recepts.adapter = context?.let { ReceptAdapter(receptList, it) }


    }
}