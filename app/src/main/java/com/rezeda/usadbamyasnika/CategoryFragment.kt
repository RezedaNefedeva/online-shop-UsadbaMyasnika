package com.rezeda.usadbamyasnika

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.helpers.DelicatesAdapter
import com.rezeda.usadbamyasnika.helpers.KolbasaAdapter2
import com.rezeda.usadbamyasnika.helpers.MeatAdapter
import com.rezeda.usadbamyasnika.helpers.ZamorozkaAdapter
import com.rezeda.usadbamyasnika.models.Delicates
import com.rezeda.usadbamyasnika.models.Kolbasa
import com.rezeda.usadbamyasnika.models.Meat
import com.rezeda.usadbamyasnika.models.Zamorozka

class CategoryFragment : Fragment(), CartClickLictener {

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
        val context = context as MainActivity2

        var listView = view.findViewById<RecyclerView>(R.id.product_list)
        var text = view.findViewById<TextView>(R.id.category_name)

        val database = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/")
        when(category_name){
            "kolbasa" ->{text.text = "Колбаса \nи колбасные изделия"

                val table = database.getReference("Kolbasa")

                table.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val allProduct = ArrayList<Kolbasa?>()
                        for(obj in snapshot.children){
                            val product = obj.getValue(Kolbasa::class.java)
                            if(product!=null) {
                                allProduct.add(product)
                            }
                            val arrayAdapter = KolbasaAdapter2(allProduct, context)
                            listView.adapter = arrayAdapter
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG).show()
                    }
                })}
            "meat" ->{text.text = "Мясо, фарш, шашлык"

                val table = database.getReference("Meat")

                table.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val allProduct = ArrayList<Meat?>()
                        for(obj in snapshot.children){
                            val product = obj.getValue(Meat::class.java)
                            if(product!=null) {
                                allProduct.add(product)
                            }
                            val arrayAdapter = MeatAdapter(allProduct, context)
                            listView.adapter = arrayAdapter
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG).show()
                    }
                })}
            "delicates" ->{text.text = "Мясные \nделикатесы"

                val table = database.getReference("Delicates")

                table.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val allProduct = ArrayList<Delicates?>()
                        for(obj in snapshot.children){
                            val product = obj.getValue(Delicates::class.java)
                            if(product!=null) {
                                allProduct.add(product)
                            }
                            val arrayAdapter = DelicatesAdapter(allProduct, context)
                            listView.adapter = arrayAdapter
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG).show()
                    }
                })}
            "zamorozka" ->{text.text = "Замороженные \nполуфабрикаты"

                val table = database.getReference("Zamorozka")

                table.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val allProduct = ArrayList<Zamorozka?>()
                        for(obj in snapshot.children){
                            val product = obj.getValue(Zamorozka::class.java)
                            if(product!=null) {
                                allProduct.add(product)
                            }
                            val arrayAdapter = ZamorozkaAdapter(allProduct, context)
                            listView.adapter = arrayAdapter
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG).show()
                    }
                })}
        }
        return view
    }

    override fun onCartClickListener(view: View, product: Kolbasa) {
        val fragment= ProductPageFragment()
        val bundle = Bundle()
        bundle.putInt("ID", ID)
        findNavController().navigate(R.id.action_categoryFragment_to_productPageFragment)
//        supportFragmentManager.beginTransaction().replace(R.id.contentContainerT, your_fragment).addToBackStack(null).commit()
    }
}