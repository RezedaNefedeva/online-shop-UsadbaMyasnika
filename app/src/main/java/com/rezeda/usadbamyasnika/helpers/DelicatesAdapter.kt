package com.rezeda.usadbamyasnika.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.R
import com.rezeda.usadbamyasnika.models.Delicates
import com.rezeda.usadbamyasnika.models.Kolbasa

class DelicatesAdapter : RecyclerView.Adapter<DelicatesAdapter.MyViewHolder>() {

    private val delicatesList = ArrayList<Delicates>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DelicatesAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item_design, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DelicatesAdapter.MyViewHolder, position: Int) {
        val currentitem = delicatesList[position]
        val id = when(currentitem.img){
            "rebra_kopch" -> R.drawable.rebra_kopch
            "meat_kopch" -> R.drawable.meat_kopch
            "grudinka_marin" -> R.drawable.grudinka_marin
            else -> R.drawable.grudinka_kopch
        }
        holder.img.setImageResource(id)
        holder.title.text = currentitem.title
        holder.weight.text = currentitem.weight
        holder.price.text = currentitem.price
    }

    override fun getItemCount(): Int {
        return delicatesList.size
    }

    fun updateDelicatesList (delicatesList: List<Delicates>){
        this.delicatesList.clear()
        this.delicatesList.addAll(delicatesList)
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