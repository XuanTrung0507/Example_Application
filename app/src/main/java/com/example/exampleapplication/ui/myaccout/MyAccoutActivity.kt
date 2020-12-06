package com.example.exampleapplication.ui.myaccout

import android.os.Bundle
import android.view.Menu
import com.example.example.data.StorageData
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_my_accout.*

class MyAccoutActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_my_accout
    }

//    override fun onCreateActivity(savedInstanceState: Bundle?) {
//       // addToolbar(toolbar_myaccout)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addToolbar(toolbar_myaccout)
    }

    override fun onResume() {
        super.onResume()
        StorageData.instance.apply {
            txtMyEmail.text = email
//            Picasso.get()
//                .load(avatar)
//                .placeholder(R.drawable.olloman2x)
//                .error(R.drawable.ollo2x)
//                .into(imgAvatar)
            txtMyName.text = fullNameUser
            txtTitleUserName.text = userName
            txtMyUserName.text = userName
            txtMyPhone.text = phoneUser
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
