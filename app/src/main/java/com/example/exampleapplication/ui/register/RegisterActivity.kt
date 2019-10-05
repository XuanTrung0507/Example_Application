package com.example.exampleapplication.ui.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.example.Network.AuthenticateFunctions
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.data.ExCheckInput
import com.example.exampleapplication.ui.login.LoginActivity
import com.example.exampleapplication.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_register
    }

//    override fun onCreateActivity(savedInstanceState: Bundle?) {
//        txvRegister.setOnClickListener {
//            startActivity(Intent(this,LoginActivity::class.java))
//        }
//        bntRegister.setOnClickListener {
//            if (isNetworkConnected()){
//                if (verifyInputRegister()) {
//                    AuthenticateFunctions.callApiRegister(
//                        this,
//                        edtRegisterEmail.text.toString(),
//                        edtRegisterFullName.text.toString(),
//                        edtRegisterPass.text.toString(),
//                        edtRegisterNumberPhone.text.toString(),
//                        edtRegisterUserName.text.toString(),
//                        ::callbackRegister
//                    )
//                    startActivity(Intent(this, NavigationActivity::class.java))
//                }
//            }
//        }
   // }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        txvRegister.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        bntRegister.setOnClickListener {
            if (isNetworkConnected()){
                if (verifyInputRegister()) {
                    AuthenticateFunctions.callApiRegister(
                        this,
                        edtRegisterEmail.text.toString(),
                        edtRegisterFullName.text.toString(),
                        edtRegisterPass.text.toString(),
                        edtRegisterNumberPhone.text.toString(),
                        edtRegisterUserName.text.toString(),
                        ::callbackRegister
                    )
                    startActivity(Intent(this, NavigationActivity::class.java))
                }
            }
        }
    }

    @SuppressLint("ShowToast")
    private fun verifyInputRegister():Boolean{
        if (edtRegisterFullName.text.isEmpty()|| edtRegisterConfirmPass.text.isEmpty() ||
            edtRegisterEmail.text.isEmpty() || edtRegisterNumberPhone.text.isEmpty()||
            edtRegisterPass.text.isEmpty()|| edtRegisterUserName.text.isEmpty()) {
                Toast.makeText(this,R.string.check_length_input,Toast.LENGTH_SHORT).show()
            return false
        }
        if(ExCheckInput.verifyEmail(edtRegisterEmail.text.toString(),this)){
            Toast.makeText(this,R.string.check_input_verify_mail,Toast.LENGTH_SHORT).show()
            return false
        }
        if (edtRegisterPass.text.toString()!= edtRegisterConfirmPass.text.toString()){
            Toast.makeText(this,R.string.check_confirm_pass,Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    private fun callbackRegister() {
        AuthenticateFunctions.callApiLogin(
            this@RegisterActivity, edtRegisterEmail.text.toString(), edtRegisterPass.text.toString(),
            ::callback
        )
    }
    private fun callback() {
        Intent(this, NavigationActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(this)
            finish()
        }
    }
}

