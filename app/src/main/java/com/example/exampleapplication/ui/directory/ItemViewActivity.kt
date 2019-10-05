package com.example.exampleapplication.ui.directory

import android.os.Bundle
import com.example.example.data.ExConstants.COLLECTION_ID
import com.example.example.data.ExConstants.ITEM_NAME
import com.example.example.data.ExConstants.ITEM_PRICE
import com.example.exampleapplication.R
import com.example.exampleapplication.base.BaseActivity
import kotlinx.android.synthetic.main.activity_item_view.*

class ItemViewActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_item_view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val collectionId = intent.extras?.getInt(COLLECTION_ID)
        val nameItem = intent.extras?.getString(ITEM_NAME)
        val priceItem = intent.extras?.getString(ITEM_PRICE)

        if (collectionId != null) {
            img__view_item.setImageResource(collectionId)
            txv_item_name.text = nameItem
            txv_item_price.text = priceItem
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
