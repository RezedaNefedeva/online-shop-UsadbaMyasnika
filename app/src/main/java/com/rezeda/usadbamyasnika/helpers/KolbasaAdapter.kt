package com.rezeda.usadbamyasnika.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.R
import com.rezeda.usadbamyasnika.models.Kolbasa

class KolbasaAdapter : RecyclerView.Adapter<KolbasaAdapter.MyViewHolder>() {

    private val kolbasaList = ArrayList<Kolbasa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KolbasaAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item_design, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: KolbasaAdapter.MyViewHolder, position: Int) {
        val currentitem = kolbasaList[position]

        val id = when(currentitem.img){
            "kolbasa_dom" -> R.drawable.kolbasa_dom
            "kolbasa_konina" -> R.drawable.kolbasa_konina
            "kolbasa_varen" -> R.drawable.kolbasa_varen
            else -> R.drawable.kolbasa_zapech
        }
        holder.img.setImageResource(id)

        holder.title.text = currentitem.title
        holder.weight.text = currentitem.weight
        holder.price.text = currentitem.price
    }

    override fun getItemCount(): Int {
        return kolbasaList.size
    }

    fun updateKolbasaList (kolbasaList: List<Kolbasa>){
        this.kolbasaList.clear()
        this.kolbasaList.addAll(kolbasaList)
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