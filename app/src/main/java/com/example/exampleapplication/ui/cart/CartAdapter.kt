package com.example.exampleapplication.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapplication.R
import kotlinx.android.synthetic.main.recycler_view_cart_item.view.*
import kotlinx.android.synthetic.main.recyclerview_directory_item.view.*

class CartAdapter(private val listItem : MutableList<DataCart>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        with(holder){
            val itemList = listItem[position]
            imgCart.setImageResource(itemList.imgCart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_cart_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val imgCart: ImageView = view.img_item_cart}
}
