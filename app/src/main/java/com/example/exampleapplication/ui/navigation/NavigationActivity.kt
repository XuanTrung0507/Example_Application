package com.example.exampleapplication.ui.navigation

import android.content.Intent
import android.os.Bundle
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
import com.example.example.data.StorageData
import com.example.exampleapplication.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.login.LoginActivity
import kotlinx.android.synthetic.main.app_bar_navigation.*

class NavigationActivity : BaseActivity() {
    override val layout: Int
        get() = R.layout.activity_navigation

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar: Toolbar = findViewById(R.id.toolbar_navigation)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //Luôn hiển thị AppBar
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_map,
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
                R.id.nav_map -> txv_title_navigation.text = getText(R.string.menu_map)
                R.id.nav_laundry_drop_off -> txv_title_navigation.text = getText(R.string.menu__laundry_drop_off)
            }
//            if(destination.id == R.id.nav_host_fragment) {
//                toolbar.visibility = View.GONE
//                //bottomNavigationView.visibility = View.GONE
//            } else {
//                toolbar.visibility = View.VISIBLE
//                //bottomNavigationView.visibility = View.VISIBLE
//            }
        }
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_logout -> {
                StorageData.instance.logOutUser()
                startActivity(Intent(this,LoginActivity::class.java))
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
}
