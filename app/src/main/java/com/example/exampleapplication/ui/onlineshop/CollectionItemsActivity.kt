package com.example.exampleapplication.ui.onlineshop

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bk.internollo.UI.OnlineShopping.ItemGroupAdapter
import com.example.example.Network.AuthenticateFunctions
import com.example.example.Network.ListItemProductCollection
import com.example.example.data.ExExtraKey.COLLECTION_ID
import com.example.exampleapplication.BaseActivity
import com.example.exampleapplication.R
import kotlinx.android.synthetic.main.activity_collection_items.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Response

class CollectionItemsActivity : BaseActivity() {
    override val layout: Int
        get() = R.layout.activity_collection_items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        txv_toolbar.text = "Shop"

        recyclerItemGroupCollection.layoutManager = LinearLayoutManager(this)
        recyclerItemGroupCollection.setHasFixedSize(true)
        val collectionId = intent.extras?.getString(COLLECTION_ID)
        if (collectionId != null) {
            if(collectionId.isNotEmpty()){
                AuthenticateFunctions.getItemProductCollection(this, collectionId, :: responseItemProduct)
            }
        }
    }
    private fun responseItemProduct(response: @ParameterName(name = "response") Response<ListItemProductCollection>) {
        recyclerItemGroupCollection.apply {
            layoutManager = LinearLayoutManager(this@CollectionItemsActivity)
            adapter = response.body()?.data?.products?.let { ItemGroupAdapter(it) }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
