package com.bk.internollo.UI.OnlineShopping

import android.annotation.SuppressLint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Network.DataProductCollection
import com.example.exampleapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_group_collection.view.*

class ItemGroupAdapter (private var itemsGroup : List<DataProductCollection>) : RecyclerView.Adapter<ItemGroupAdapter.ViewHolder>(){
    class ViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val imgGroup : ImageView = view.imgItemsGroupCollection
        val nameItemCollection : TextView = view.txvNameItemsGroupCollection
        val priceItemCollection : TextView = view.txvPriceItemGroupCollection
        val saleItemCollection : TextView = view.txvSaleItemGroupCollection
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.recyclerview_item_group_collection,p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsGroup.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        with(p0){
            val itemsCollection = itemsGroup[p1]
            if(itemsCollection.images.isNotEmpty()){
                Picasso.get()
                    .load(itemsCollection.images[0].url)
                    .placeholder(R.drawable.icon_example)
                    .error(R.drawable.icon_example)
                    .fit()
                    .into(imgGroup)
            }
            nameItemCollection.text = itemsCollection.name
            priceItemCollection.text = "S$${itemsCollection.price}"
            // Set text gạch ngang
            val name = "${itemsCollection.sale_price}$"
            val mStrikeThrough = StrikethroughSpan()
            val mBSpannableString = SpannableString(name)
            mBSpannableString.setSpan(mStrikeThrough,0,mBSpannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            saleItemCollection.text = mBSpannableString
            if (itemsCollection.sale_price == null){
                saleItemCollection.visibility = View.GONE
            }
        }
    }
}