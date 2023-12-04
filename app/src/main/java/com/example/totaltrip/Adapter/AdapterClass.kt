package com.example.totaltrip.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.totaltrip.Fragment.HomeFragment
import com.example.totaltrip.ModelClass.StudentModelClass
import com.example.totaltrip.R

class AdapterClass(var homefragment: HomeFragment, var list: ArrayList<StudentModelClass>,
                   var onItemclick:(place: String, Rate: String, img: String,key:String)->Unit
) :
    RecyclerView.Adapter<AdapterClass.Myviewholder>() {
    class Myviewholder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var place: TextView= itemView.findViewById(R.id.palce)
        var price: TextView= itemView.findViewById(R.id.price)
        var img : ImageView = itemView.findViewById(R.id.img)
        var fullcard : CardView = itemView.findViewById(R.id.fullcard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.item_file, parent, false)
        return Myviewholder(View)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        holder.place.text = list[position].palce
        holder.price.text = list[position].price
        Glide.with(homefragment).load(list[position].ImageUri).into(holder.img)

        holder.fullcard.setOnClickListener {
            onItemclick.invoke(
                list[position].palce,
                list[position].Rating,
                list[position].ImageUri,
                list[position].key,
            )
        }

    }
}