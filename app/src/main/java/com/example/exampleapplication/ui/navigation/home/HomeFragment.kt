package com.example.exampleapplication.ui.navigation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.profile.ProfileActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val bnt : Button = root.findViewById(R.id.bntpro)
        bnt.setOnClickListener {
            startActivity(Intent(context, ProfileActivity::class.java))
        }
        return root
    }
}