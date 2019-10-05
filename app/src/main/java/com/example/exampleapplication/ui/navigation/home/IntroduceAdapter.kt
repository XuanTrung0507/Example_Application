package com.example.exampleapplication.ui.navigation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapplication.R
import kotlinx.android.synthetic.main.recyclerview_introduce_item.view.*

class IntroduceAdapter (private val listItemIntroduce : List<DataRecyclerIntroduce>,
                        val calback : (Int,String,String) -> Unit) : RecyclerView.Adapter<IntroduceAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_introduce_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItemIntroduce.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            val item = listItemIntroduce[position]
            priceIntroduce.text = item.priceIntroduce
            nameIntroduce.text = item.nameIntroduce
            imgItemIntroduce.setImageResource(item.imgUrlIntroduce)

            imgItemIntroduce.setOnClickListener {
                calback(item.imgUrlIntroduce,
                    item.priceIntroduce,
                    item.nameIntroduce)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgItemIntroduce : ImageView = view.img_introduce
        val nameIntroduce : TextView = view.txv_name_introduce
        val priceIntroduce : TextView = view.txv_introduce_price
    }
}