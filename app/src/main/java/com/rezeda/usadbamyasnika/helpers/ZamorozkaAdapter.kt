package com.rezeda.usadbamyasnika.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.R
import com.rezeda.usadbamyasnika.models.Kolbasa
import com.rezeda.usadbamyasnika.models.Zamorozka

class ZamorozkaAdapter : RecyclerView.Adapter<ZamorozkaAdapter.MyViewHolder>() {

    private val zamorozkaList = ArrayList<Zamorozka>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZamorozkaAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item_design, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ZamorozkaAdapter.MyViewHolder, position: Int) {
        val currentitem = zamorozkaList[position]

        holder.title.text = currentitem.title
        holder.weight.text = currentitem.weight
        holder.price.text = currentitem.price
    }

    override fun getItemCount(): Int {
        return zamorozkaList.size
    }

    fun updateZamorozkaList (zamorozkaList: List<Zamorozka>){
        this.zamorozkaList.clear()
        this.zamorozkaList.addAll(zamorozkaList)
        notifyDataSetChanged()
    }

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.product_img)
        val title: TextView = itemView.findViewById(R.id.product_title)
        val weight: TextView = itemView.findViewById(R.id.product_weight)
        val price: TextView = itemView.findViewById(R.id.product_price)
//        val product_addToCart: Button = itemView.findViewById(R.id.product_addToCart)
    }

}