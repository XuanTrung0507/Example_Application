package com.example.exampleapplication.ui.directory.laptop

import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.exampleapplication.R
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.ui.navigation.home.DataRecyclerIntroduce
import com.example.exampleapplication.ui.navigation.home.IntroduceAdapter
import kotlinx.android.synthetic.main.activity_item_view.*
import kotlinx.android.synthetic.main.activity_laptop.*

class LaptopActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_laptop
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_laptop)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        recycler_directory_laptop.layoutManager = StaggeredGridLayoutManager(2, GridLayout.VERTICAL)
        recycler_directory_laptop.setHasFixedSize(true)

        addItemLaptop(recycler_directory_laptop)
    }

    private fun addItemLaptop(layout: RecyclerView){
        layout.adapter = LaptopAdapter(
            mutableListOf(
                DataLaptop(R.drawable.lap1,"Acer Aspire A315 51 52AB i5 7200U", "12.490.000 VND" ),
                DataLaptop(R.drawable.laptop2,"Asus S510UA i3 7100U", "12.490.000 VND" ),
                DataLaptop(R.drawable.laptop3,"Lap Top", "1.000.000VND" ),
                DataLaptop(R.drawable.imglaptop1,"Lap Top", "1.000.000VND" ),
                DataLaptop(R.drawable.aceraspire,"Lap Top", "1.000.000VND" ),
                DataLaptop(R.drawable.imglaptop2,"Lap Top", "1.000.000VND" ),
                DataLaptop(R.drawable.laptop2,"Lap Top", "1.000.000VND" )
            )
        )
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
