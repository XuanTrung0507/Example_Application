package com.example.exampleapplication.ui.navigation.onlineshop

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bk.internollo.UI.OnlineShopping.CollectionItemsAdapter
import com.example.example.Network.AuthenticateFunctions
import com.example.example.Network.ListCollection
import com.example.example.data.ExExtraKey.COLLECTION_ID
import com.example.exampleapplication.BaseActivity
import com.example.exampleapplication.R
import com.example.exampleapplication.ui.navigation.NavigationActivity
import com.example.exampleapplication.ui.onlineshop.CollectionItemsActivity
import kotlinx.android.synthetic.main.fragment_online_shop.*
import kotlinx.android.synthetic.main.fragment_online_shop.view.*
import retrofit2.Response

class OnlineShopFragment : Fragment() {

    private lateinit var toolsViewModel: OnlineShopViewModel

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        toolsViewModel = ViewModelProviders.of(this).get(OnlineShopViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_online_shop, container, false)
        root.recyclerOnlineShop.layoutManager = GridLayoutManager(activity, 2,
            GridLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        root.recyclerOnlineShop.setHasFixedSize(true)
        AuthenticateFunctions.getAllCollection(activity as BaseActivity, ::returnBodyAllCollection)
        return root
    }

    @SuppressLint("WrongConstant")
    private fun returnBodyAllCollection(response: @ParameterName(name = "response") Response<ListCollection>) {
        recyclerOnlineShop.apply {
            layoutManager = GridLayoutManager(activity,2, GridLayout.VERTICAL,false) as RecyclerView.LayoutManager?
            adapter = response.body()?.data?.let { CollectionItemsAdapter(it,::callBack) }
        }
    }

    private fun callBack(idCollection: String) {
        val intent = Intent(context, CollectionItemsActivity::class.java)
        val bundle = Bundle()
        bundle.putString(COLLECTION_ID,idCollection)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}