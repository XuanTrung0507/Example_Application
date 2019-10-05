package com.example.exampleapplication.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.data.ExConstants
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.navigation.home.DataRecyclerDirectory
import com.example.exampleapplication.ui.navigation.home.DirectoryAdapter
import com.example.exampleapplication.ui.navigation.home.IntroduceAdapter
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.fragment_home.*

class CartActivity : AppCompatActivity() {

    var list: MutableList<DataCart>? = mutableListOf()

    var position = 0

    private var item: CartAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recycler_my_cart.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recycler_my_cart.setHasFixedSize(true)
        addItemCart(recycler_my_cart)

    }

    private fun addItemDirectory(view : View){
        position++
        list?.add(DataCart(R.drawable.icon_example))
        item?.notifyItemInserted(position)
    }

    private fun addItemCart(layout: RecyclerView){
        list?.add(DataCart(R.drawable.icon_example))
    }
}
