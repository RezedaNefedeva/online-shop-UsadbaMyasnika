package com.rezeda.usadbamyasnika

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.rezeda.usadbamyasnika.helpers.DelicatesAdapter
import com.rezeda.usadbamyasnika.helpers.KolbasaAdapter
import com.rezeda.usadbamyasnika.helpers.MeatAdapter
import com.rezeda.usadbamyasnika.helpers.ZamorozkaAdapter
import com.rezeda.usadbamyasnika.models.DelicatesViewModel
import com.rezeda.usadbamyasnika.models.Kolbasa
import com.rezeda.usadbamyasnika.models.KolbasaViewModel
import com.rezeda.usadbamyasnika.models.Meat
import com.rezeda.usadbamyasnika.models.MeatViewModel
import com.rezeda.usadbamyasnika.models.ZamorozkaViewModel

class CategoryFragment : Fragment(), CartClickLictener {

    private lateinit var kolbasaViewModel : KolbasaViewModel
    private lateinit var delicatesViewModel : DelicatesViewModel
    private lateinit var meatViewModel : MeatViewModel
    private lateinit var zamorozkaViewModel : ZamorozkaViewModel
    private lateinit var kolbasaRecyclerView: RecyclerView
    private lateinit var delicatesRecyclerView: RecyclerView
    private lateinit var meatRecyclerView: RecyclerView
    private lateinit var zamorozkaRecyclerView: RecyclerView
    lateinit var kolbasaAdapter: KolbasaAdapter
    lateinit var delicatesAdapter: DelicatesAdapter
    lateinit var meatAdapter: MeatAdapter
    lateinit var zamorozkaAdapter: ZamorozkaAdapter

    companion object{
        var category_name: String = "null"
        var ID: Int = 0
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        val back = view.findViewById<ImageView>(R.id.back_catalog)

        back.setOnClickListener { findNavController().navigate(R.id.action_categoryFragment_to_catalogFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var text = view.findViewById<TextView>(R.id.category_name)

        when(category_name) {
            "kolbasa" ->{
                text.text = "Колбасы \nи колбасные изделия"
                kolbasaRecyclerView = view.findViewById(R.id.product_list)
                kolbasaRecyclerView.layoutManager = LinearLayoutManager(context)
                kolbasaRecyclerView.setHasFixedSize(true)
                kolbasaAdapter = KolbasaAdapter()
                kolbasaRecyclerView.adapter = kolbasaAdapter

                kolbasaViewModel = ViewModelProvider(this).get(KolbasaViewModel::class.java)
                kolbasaViewModel.allKolbasa.observe(
                    viewLifecycleOwner,
                    Observer { kolbasaAdapter.updateKolbasaList(it) })
            }
            "delicates" ->{
                text.text = "Мясные деликатесы"
                delicatesRecyclerView = view.findViewById(R.id.product_list)
                delicatesRecyclerView.layoutManager = LinearLayoutManager(context)
                delicatesRecyclerView.setHasFixedSize(true)
                delicatesAdapter = DelicatesAdapter()
                delicatesRecyclerView.adapter = delicatesAdapter

                delicatesViewModel = ViewModelProvider(this).get(DelicatesViewModel::class.java)
                delicatesViewModel.allDelicates.observe(
                    viewLifecycleOwner,
                    Observer { delicatesAdapter.updateDelicatesList(it) })
            }
            "meat" ->{
                text.text = "Мясо \nи мясные полуфабрикаты"
                meatRecyclerView = view.findViewById(R.id.product_list)
                meatRecyclerView.layoutManager = LinearLayoutManager(context)
                meatRecyclerView.setHasFixedSize(true)
                meatAdapter = MeatAdapter()
                meatRecyclerView.adapter = meatAdapter

                meatViewModel = ViewModelProvider(this).get(MeatViewModel::class.java)
                meatViewModel.allMeat.observe(
                    viewLifecycleOwner,
                    Observer { meatAdapter.updateMeatList(it) })
            }
            "zamorozka" ->{
                text.text = "Замороженные полуфабрикаты"
                zamorozkaRecyclerView = view.findViewById(R.id.product_list)
                zamorozkaRecyclerView.layoutManager = LinearLayoutManager(context)
                zamorozkaRecyclerView.setHasFixedSize(true)
                zamorozkaAdapter = ZamorozkaAdapter()
                zamorozkaRecyclerView.adapter = zamorozkaAdapter

                zamorozkaViewModel = ViewModelProvider(this).get(ZamorozkaViewModel::class.java)
                zamorozkaViewModel.allZamorozka.observe(
                    viewLifecycleOwner,
                    Observer { zamorozkaAdapter.updateZamorozkaList(it) })
            }

        }
    }

    override fun onCartClickListener(view: View, product: Kolbasa) {
        val fragment= ProductPageFragment()
        val bundle = Bundle()
        bundle.putInt("ID", ID)
        findNavController().navigate(R.id.action_categoryFragment_to_productPageFragment)
//        supportFragmentManager.beginTransaction().replace(R.id.contentContainerT, your_fragment).addToBackStack(null).commit()
    }
}