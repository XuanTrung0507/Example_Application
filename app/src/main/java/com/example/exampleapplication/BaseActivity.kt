package com.example.exampleapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.RelativeLayout
import androidx.appcompat.widget.Toolbar
import com.example.example.data.StorageData
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity  : AppCompatActivity() {

    abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val mainView = LayoutInflater.from(this).inflate(layout, null)
        mainView.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT)
        rootView.addView(mainView)
        rootView.removeView(viewLoading)
        StorageData.instance.activity = this
    }

    fun isNetworkConnected(): Boolean{
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val active = cm.activeNetworkInfo
        if (active == null)
        {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setMessage(R.string.check_internet_connection)
            builder.setNegativeButton(R.string.cancel
            ) { _, id ->
                // User cancelled the dialog
            }
            builder.create().show()
            return false
        }
        return true
    }

    fun showProgressLoading() {
        hideKeyboard()
        rootView.removeView(viewLoading)
        rootView.addView(viewLoading)
        progess.visibility = View.VISIBLE
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
    fun dismissProgressLoading() {
        rootView.removeView(viewLoading)
        progess.visibility = View.GONE
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
    private fun hideKeyboard() {
        currentFocus?.run {
            val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }
    }

    fun addToolbar(){
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
