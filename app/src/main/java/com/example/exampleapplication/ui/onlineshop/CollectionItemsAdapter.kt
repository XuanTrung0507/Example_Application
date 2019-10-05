package com.bk.internollo.UI.OnlineShopping


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Network.DataCollectionGroup
import com.example.exampleapplication.R
import kotlinx.android.synthetic.main.recycler_colection_item_online.view.*

class CollectionItemsAdapter (private var collection : List<DataCollectionGroup>, val callback : (String) -> Unit) : RecyclerView.Adapter<CollectionItemsAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameCollection : TextView = view.txvNameColection
        val imgCollection : ImageView = view.imgColection
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.recycler_colection_item_online,p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        with(p0){
            val itemsCollection = collection[p1]
            nameCollection.text = itemsCollection.name
            com.squareup.picasso.Picasso.get()
                .load("https://sohanews.sohacdn.com/2018/11/6/photo-1-1541483747699708526153.jpg")
                .placeholder(R.drawable.icon_example)
                .error(R.drawable.ic_error_black_24dp)
                .fit()
                .into(imgCollection)
            imgCollection.setOnClickListener {
                callback(itemsCollection.id)
            }
        }
    }
}
