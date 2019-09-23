package com.example.exampleapplication.data

import android.content.Context
import android.widget.Toast
import com.example.example.data.ExConstants
import com.example.exampleapplication.R
import java.util.regex.Pattern

object ExCheckInput {
    fun verifyEmail(email: String, context: Context): Boolean {
        val inputStr = email as CharSequence
        val pattern = Pattern.compile(ExConstants.EMAIL_VERIFY, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return if (matcher.matches()) {
            true
        } else {
            Toast.makeText(context, R.string.check_input_verify_mail, Toast.LENGTH_SHORT).show()
            false
        }
    }
}