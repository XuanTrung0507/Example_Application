package com.example.exampleapplication.ui.directory.laptop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.navigation.home.DirectoryAdapter
import kotlinx.android.synthetic.main.recycler_directory_laptop.view.*

class LaptopAdapter (private val listsLaptop : MutableList<DataLaptop>): RecyclerView.Adapter<LaptopAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img : ImageView = view.img_directory_laptop
        val name : TextView = view.directory_name_laptop
        val price : TextView = view.directory_price_laptop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_directory_laptop,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listsLaptop.size
    }

    override fun onBindViewHolder(holder: LaptopAdapter.ViewHolder, position: Int) {
        with(holder){
            val itemList = listsLaptop[position]
            price.text = itemList.price
            name.text = itemList.name
//            com.squareup.picasso.Picasso.get()
//                .load(R.drawable.icon_example)
//                .placeholder(R.drawable.icon_example)
//                .error(R.drawable.icon_example)
//                .fit()
//                .into(imgGroup)
            img.setImageResource(itemList.imgLaptop)
//            imgGroup.setOnClickListener {
//                listenClick.onGroupClick(holder,position)
//            }
        }
    }

}