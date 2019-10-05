package com.example.exampleapplication.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.example.Network.AuthenticateFunctions
import com.example.example.data.StorageData
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.navigation.NavigationActivity
import com.example.exampleapplication.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

//    override fun onCreateActivity(savedInstanceState: Bundle?) {
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isNetworkConnected()
        if(StorageData.instance.tokenUser != ""){
            startActivity(Intent(this@LoginActivity, NavigationActivity::class.java))
            finish()
        }
        Log.e("aaa",StorageData.instance.tokenUser.toString())
        bnt_login.setOnClickListener {
            if (isNetworkConnected()) {
                if (verifyInputCharacters()){
                    AuthenticateFunctions.callApiLogin(
                        this,
                        edtLoginFullName.text.toString(),
                        edtLoginPass.text.toString(),
                        ::callback
                    )
                }
            }
        }
        tv_login_register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    private fun callback() {
        finish()
        startActivity(Intent(this@LoginActivity, NavigationActivity::class.java))
        Toast.makeText(this@LoginActivity, R.string.login_success, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("ShowToast")
    private fun verifyInputCharacters(): Boolean{
        if(edtLoginFullName.text.isEmpty() || edtLoginPass.text.isEmpty() ){
            Toast.makeText(this,R.string.check_length_input,Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
