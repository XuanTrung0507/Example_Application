package com.example.exampleapplication.ui.navigation.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.data.ExConstants.COLLECTION_ID
import com.example.example.data.ExConstants.ITEM_NAME
import com.example.example.data.ExConstants.ITEM_PRICE
import com.example.exampleapplication.R
import com.example.exampleapplication.base.BaseFragment
import com.example.exampleapplication.ui.directory.ItemViewActivity
import com.example.exampleapplication.ui.directory.laptop.LaptopActivity
import com.example.exampleapplication.ui.myaccout.MyAccoutActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), ItemGroupHome1Click, ItemIntroduceClick {
    override fun onGroupIntroduceClick(view: IntroduceAdapter.ViewHolder, position: Int, img: Int) {
        startActivity(Intent(context,
            LaptopActivity::class.java))
    }

    private var introduceAdapter: IntroduceAdapter? = null

    override fun getRootLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setupViewModel() {}

    override fun setupUI(view: View) {
        recycler_directory.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recycler_directory.setHasFixedSize(true)
        addItemDirectory(recycler_directory)

        //recycler_introduce.layoutManager = StaggeredGridLayoutManager(2, GridLayout.VERTICAL)
        //recycler_introduce.setHasFixedSize(true)
        recycler_introduce.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recycler_introduce.setHasFixedSize(true)
        addItemIntroduce(recycler_introduce)

        img_home_user.setOnClickListener {
            //Navigation.createNavigateOnClickListener(R.id.nav_home,null)
            startActivity(Intent(context,MyAccoutActivity::class.java))
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        return inflater.inflate(getRootLayoutId(), container, false)
    }

    override fun onGroupClick(view: DirectoryAdapter.ViewHolder, position: Int) {
        when(position){
            0 ->{
                startActivity(Intent(context,
                    LaptopActivity::class.java))
            }
        }
    }
    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("WrongConstant")

    private fun addItemDirectory(layout: RecyclerView){
        layout.adapter = DirectoryAdapter(
            listOf(
                DataRecyclerDirectory(R.drawable.laptop11,"Laptop"),
                DataRecyclerDirectory(R.drawable.pc_gaming,"PC Gaming"),
                DataRecyclerDirectory(R.drawable.dienthoai,"Điện Thoại"),
                DataRecyclerDirectory(R.drawable.tablet,"Tablet")
            ),this
        )
        //layout.adapter = introduceAdapter
    }

    private fun addItemIntroduce(layout: RecyclerView){
        layout.adapter = IntroduceAdapter(
            listOf(
                DataRecyclerIntroduce(R.drawable.lap1,"Acer Aspire A315 51 52AB i5 7200U", "12.490.000 VND" ),
                DataRecyclerIntroduce(R.drawable.laptop2,"Asus S510UA i3 7100U", "12.490.000 VND" ),
                DataRecyclerIntroduce(R.drawable.laptop3,"Lap Top", "1.000.000VND" ),
                DataRecyclerIntroduce(R.drawable.imglaptop1,"Lap Top", "1.000.000VND" ),
                DataRecyclerIntroduce(R.drawable.aceraspire,"Lap Top", "1.000.000VND" ),
                DataRecyclerIntroduce(R.drawable.imglaptop2,"Lap Top", "1.000.000VND" ),
                DataRecyclerIntroduce(R.drawable.laptop2,"Lap Top", "1.000.000VND" )
            ),::callback
        )
    }

    private fun callback(imgUrl: Int, name:String,price : String) {
        val intent = Intent(context, ItemViewActivity::class.java)
        val bundle = Bundle()
        bundle.putInt(COLLECTION_ID, imgUrl)
        bundle.putString(ITEM_NAME,name)
        bundle.putString(ITEM_PRICE,price)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}