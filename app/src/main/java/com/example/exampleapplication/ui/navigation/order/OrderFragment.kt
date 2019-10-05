package com.example.exampleapplication.ui.navigation.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.exampleapplication.R

class OrderFragment : Fragment() {
    private lateinit var galleryViewModel: OrderViewModel
    //lateinit var homeFragment: HomeFragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(OrderViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_order, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(this, Observer {
            textView.text = it
        })
        val bnt:Button = root.findViewById(R.id.bntadd)
        bnt.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_home,null))
        return root
    }
}