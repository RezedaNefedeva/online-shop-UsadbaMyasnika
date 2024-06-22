package com.rezeda.usadbamyasnika

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.Kolbasa

class ProductPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_product_page, container, false)
        val product_page_img = view.findViewById<ImageView>(R.id.product_page_img)
        val product_page_title = view.findViewById<TextView>(R.id.product_page_title)
        val product_page_text = view.findViewById<TextView>(R.id.product_page_text)
        val product_page_weight = view.findViewById<TextView>(R.id.product_page_weight)
        val product_page_price = view.findViewById<TextView>(R.id.product_page_price)

        val database = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/")
        when(CategoryFragment.category_name) {
            "kolbasa" -> {
                val table = database.getReference("Kolbasa")
                table.child(CategoryFragment.ID.toString()).addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val product = snapshot.getValue(Kolbasa::class.java)
                        product_page_title.text = product?.title
                        product_page_price.text = product?.price
                        product_page_weight.text = product?.weight
                        val id = when(product?.img){
                            "kolbasa_dom" -> R.drawable.kolbasa_dom
                            "kolbasa_konina" -> R.drawable.kolbasa_konina
                            "kolbasa_varen" -> R.drawable.kolbasa_varen
                            else -> R.drawable.kolbasa_varen
                        }
                        product_page_img.setImageResource(id)

                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG).show()
                    }
                })}
        }

        return view
    }

}