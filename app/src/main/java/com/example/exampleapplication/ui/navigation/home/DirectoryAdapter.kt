package com.example.exampleapplication.ui.navigation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapplication.R
import kotlinx.android.synthetic.main.recyclerview_directory_item.view.*

class DirectoryAdapter(private val listItem : List<DataRecyclerDirectory>,
                       private val listenClick : ItemGroupHome1Click) : RecyclerView.Adapter<DirectoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_directory_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            val itemList = listItem[position]
            nameGroup.text = itemList.nameGroup
//            com.squareup.picasso.Picasso.get()
//                .load(R.drawable.icon_example)
//                .placeholder(R.drawable.icon_example)
//                .error(R.drawable.icon_example)
//                .fit()
//                .into(imgGroup)
            imgGroup.setImageResource(itemList.imgUrl)

            imgGroup.setOnClickListener {
                listenClick.onGroupClick(holder,position)
            }
        }
    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val imgGroup: ImageView = view.img_group_directory
        val nameGroup: TextView = view.txv_group_directory
    }
}
