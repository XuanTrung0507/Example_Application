package com.example.exampleapplication.ui.profile

import android.os.Bundle
import com.example.example.data.StorageData
import com.example.exampleapplication.BaseActivity
import com.example.exampleapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    override val layout: Int
        get() = R.layout.activity_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addToolbar()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        StorageData.instance.apply {
            txtTitleUserProfile?.text = userName
//            txtTitleCardNumberProfile?.text = cardNumber
//            txtBalnceProfile?.text = "S$ $balance"
//            txtPointsProfile?.text = "S$ $poins"
            Picasso.get()
                .load(R.drawable.ic_user_24dp)
                .placeholder(R.drawable.ic_user_24dp)
                .error(R.drawable.ic_user_24dp)
                .into(imgProfile)
        }
    }
}
