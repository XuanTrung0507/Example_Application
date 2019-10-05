package com.example.exampleapplication.base

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
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
import com.example.exampleapplication.R
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity  : AppCompatActivity() {

    abstract fun getLayoutID(): Int
    //abstract fun onCreateActivity(savedInstanceState: Bundle?)

    var dialog : Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
      //  onCreateActivity(savedInstanceState)
//        val mainView = LayoutInflater.from(this).inflate(getLayoutID(), null)
//        mainView.layoutParams = RelativeLayout.LayoutParams(
//            RelativeLayout.LayoutParams.MATCH_PARENT,
//            RelativeLayout.LayoutParams.MATCH_PARENT)
//        rootView.addView(mainView)
//        rootView.removeView(viewLoading)
        StorageData.instance.activity = this
    }

    fun isNetworkConnected(): Boolean{
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val active = cm.activeNetworkInfo
        if (active == null)
        {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setMessage(R.string.check_internet_connection)
            builder.setNegativeButton(
                R.string.cancel
            ) { _, _ ->
                // User cancelled the dialog
            }
            builder.create().show()
            return false
        }
        return true
    }

    fun showProgressLoading() {
//        hideKeyboard()
//        rootView.removeView(viewLoading)
//        rootView.addView(viewLoading)
//        progressBar.visibility = View.VISIBLE
        dialog = Dialog(this,android.R.style.Theme_Translucent_NoTitleBar)
        val view = this.layoutInflater.inflate(R.layout.full_screen_progress_bar,null)
        dialog?.setContentView(view)
        dialog?.setCancelable(false)
        dialog?.show()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
    fun dismissProgressLoading() {
//        rootView.removeView(viewLoading)
//        progressBar.visibility = View.GONE
        dialog?.dismiss()
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
    private fun hideKeyboard() {
        currentFocus?.run {
            val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }
    }

    fun addToolbar(toolbar: Toolbar){
        //val toolbar: Toolbar = findViewById(R.id.toolbar_myaccout)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
