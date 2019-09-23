package com.example.exampleapplication.ui.navigation.laundrydropoff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.exampleapplication.R

class LaundryDopOffFragment : Fragment() {

    private lateinit var slideshowViewModel: LaundryDropOffViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(LaundryDropOffViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_laundry_drop_off, container, false)

        return root
    }
}