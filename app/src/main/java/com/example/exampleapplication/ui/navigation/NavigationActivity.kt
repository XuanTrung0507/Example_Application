package com.example.exampleapplication.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.example.Network.AuthenticateFunctions
import com.example.example.Network.CallApiGetDataUser
import com.example.example.data.StorageData
import com.example.exampleapplication.base.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.cart.CartActivity
import com.example.exampleapplication.ui.profile.ProfileActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.nav_header_navigation.view.*
import retrofit2.Response

class NavigationActivity : BaseActivity() {

    override fun getLayoutID(): Int {
        return R.layout.activity_navigation
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    //override fun onCreateActivity(savedInstanceState: Bundle?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar: Toolbar = findViewById(R.id.toolbar_navigation)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        //val header : LinearLayout = findViewById(R.id.header_profile)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //Luôn hiển thị AppBar
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_order,
                R.id.nav_laundry_drop_off,
                R.id.nav_online_shop,
                R.id.nav_share,
                R.id.nav_send),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.nav_home -> txv_title_navigation.text = getText(R.string.menu_home)
               // R.id.nav_map -> txv_title_navigation.text = getText(R.string.menu_map)
                R.id.nav_laundry_drop_off -> txv_title_navigation.text = getText(R.string.menu__laundry_drop_off)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_user -> {
                startActivity(Intent(this,ProfileActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        AuthenticateFunctions.callApiGetUserData(::callbackGetUser)
    }

    private fun callbackGetUser(response: @ParameterName(name = "response") Response<CallApiGetDataUser>) {
        //val result = response.body()?.data?.cards?.firstOrNull { it.getActive }
        response.body()?.data?.user?.apply {
            StorageData.instance.apply {
                //                cardNumber = result?.getCardsNumber
//                balance = result?.getBalance
                userName = getUserName
                fullNameUser = getFullName
                //avatar = getAvatar?.url
                phoneUser = getPhone
                //poins = getTotalPoint
                email = getEmail
                nav_view.getHeaderView(0).txv_nav_header_name.text = email
//                Picasso.get()
//                    .load(avatar)
//                    .placeholder(R.drawable.olloman2x)
//                    .error(R.drawable.olloman2x)
//                    .into(  navigationViewHome.getHeaderView(0).imgHeaderAvatar)
//                navigationViewHome.getHeaderView(0).imgHeaderIcon.visibility = View.GONE
//                navigationViewHome.getHeaderView(0).txtHeaderUsername.text = userName
            }
        }
    }
}
