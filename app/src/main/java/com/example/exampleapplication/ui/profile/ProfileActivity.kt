package com.example.exampleapplication.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.example.data.StorageData
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.login.LoginActivity
import com.example.exampleapplication.ui.myaccout.MyAccoutActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_profile
    }

//    override fun onCreateActivity(savedInstanceState: Bundle?) {
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addToolbar(toolbar_profile)
        layoutMyAccount.setOnClickListener {
            startActivity(Intent(this,MyAccoutActivity::class.java))
        }

        txv_log_out.setOnClickListener {
            StorageData.instance.logOutUser()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        StorageData.instance.apply {
            txtTitleUserProfile?.text = userName
            Picasso.get()
                .load(R.drawable.ic_user_24dp)
                .placeholder(R.drawable.ic_user_24dp)
                .error(R.drawable.ic_user_24dp)
                .into(imgProfile)
        }
    }
}
