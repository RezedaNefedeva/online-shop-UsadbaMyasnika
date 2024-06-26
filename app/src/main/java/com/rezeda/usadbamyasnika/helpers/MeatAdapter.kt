package com.rezeda.usadbamyasnika.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.R
import com.rezeda.usadbamyasnika.models.Kolbasa
import com.rezeda.usadbamyasnika.models.Meat

class MeatAdapter : RecyclerView.Adapter<MeatAdapter.MyViewHolder>() {

    private val meatList = ArrayList<Meat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeatAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item_design, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MeatAdapter.MyViewHolder, position: Int) {
        val currentitem = meatList[position]

        holder.title.text = currentitem.title
        holder.weight.text = currentitem.weight
        holder.price.text = currentitem.price
    }

    override fun getItemCount(): Int {
        return meatList.size
    }

    fun updateMeatList (meatList: List<Meat>){
        this.meatList.clear()
        this.meatList.addAll(meatList)
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