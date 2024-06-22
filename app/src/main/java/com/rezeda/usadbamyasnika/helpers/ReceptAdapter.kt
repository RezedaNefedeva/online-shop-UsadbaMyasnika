package com.rezeda.usadbamyasnika.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezeda.usadbamyasnika.R
import com.rezeda.usadbamyasnika.models.Recept

class ReceptAdapter (private var recepts: List<Recept>, private var context: Context) :
    RecyclerView.Adapter<ReceptAdapter.MyViewHolder>() {

    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        val image_recept: ImageView = view.findViewById(R.id.image_recept)
        val title_recept: TextView = view.findViewById(R.id.title_recept)
        val anons_recept: TextView = view.findViewById(R.id.anons_recept)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recept_card_design, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return recepts.count()
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val imageId = this.context.resources.getIdentifier(recepts[position].image_recept, "drawable", context.packageName)
        holder.image_recept.setImageResource(imageId)
        holder.title_recept.text = recepts[position].title_recept
        holder.anons_recept.text = recepts[position].anons_recept
    }

}