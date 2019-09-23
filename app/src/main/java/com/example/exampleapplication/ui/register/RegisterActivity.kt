package com.example.exampleapplication.ui.register

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exampleapplication.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.data.ExCheckInput
import com.example.exampleapplication.ui.login.LoginActivity
import com.example.exampleapplication.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override val layout: Int
        get() = R.layout.activity_register

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        txvRegister.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        bntRegister.setOnClickListener {
            if (isNetworkConnected()){
                if (verifyInputRegister()) {
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
}
