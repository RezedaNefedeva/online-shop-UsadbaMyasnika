package com.rezeda.usadbamyasnika.helpers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.CartClickLictener
import com.rezeda.usadbamyasnika.CategoryFragment
import com.rezeda.usadbamyasnika.R
import com.rezeda.usadbamyasnika.models.Kolbasa

class KolbasaAdapter2 (private val products:List<Kolbasa?>, private val mContext: Context) :
    RecyclerView.Adapter<KolbasaAdapter2.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val product_page_img = itemView.findViewById<ImageView>(R.id.product_page_img)
        val product_page_title = itemView.findViewById<TextView>(R.id.product_page_title)
        val product_page_weight = itemView.findViewById<TextView>(R.id.product_page_weight)
        val product_page_price = itemView.findViewById<TextView>(R.id.product_page_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item_design, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.product_page_title.text = products[position]?.title
        holder.product_page_weight.text = products[position]?.weight
        holder.product_page_price.text = products[position]?.price
        holder.itemView.setOnClickListener {
            CategoryFragment.ID = position+1
            Toast.makeText(mContext,"Проверьте интернет соединение", Toast.LENGTH_LONG).show()
        }
    }

}