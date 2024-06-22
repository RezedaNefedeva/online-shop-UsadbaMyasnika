package com.rezeda.usadbamyasnika

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.rezeda.usadbamyasnika.CategoryFragment.Companion.category_name

class CatalogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        val category_kolbasa = view.findViewById<LinearLayout>(R.id.category_kolbasa)
        val category_meat = view.findViewById<LinearLayout>(R.id.category_meat)
        val category_delicates = view.findViewById<LinearLayout>(R.id.category_delicates)
        val category_zamorozka = view.findViewById<LinearLayout>(R.id.category_zamorozka)

        category_kolbasa.setOnClickListener {
            findNavController().navigate(R.id.action_catalogFragment_to_categoryFragment)
            category_name = "kolbasa"
        }

        category_meat.setOnClickListener {
            findNavController().navigate(R.id.action_catalogFragment_to_categoryFragment)
            category_name = "meat"
        }

        category_delicates.setOnClickListener {
            findNavController().navigate(R.id.action_catalogFragment_to_categoryFragment)
            category_name = "delicates"
        }

        category_zamorozka.setOnClickListener {
            findNavController().navigate(R.id.action_catalogFragment_to_categoryFragment)
            category_name = "zamorozka"
        }

        return view
    }

}