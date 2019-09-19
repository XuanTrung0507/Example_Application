package com.example.exampleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exampleapplication.ui.login.LoginActivity
import com.example.exampleapplication.ui.navigation.NavigationActivity
import com.example.exampleapplication.ui.register.RegisterActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,LoginActivity::class.java))
    }
}
