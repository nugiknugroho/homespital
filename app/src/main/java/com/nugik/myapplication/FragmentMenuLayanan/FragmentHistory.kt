package com.nugik.myapplication.FragmentMenuLayanan

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.R
//import com.nugik.myapplication.RVAAdapter.RVAArtikelAdapter
import com.nugik.myapplication.TabLayoutAdapter.MyPagerAdapter
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_menu_history.*
import org.json.JSONObject

class FragmentHistory :Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_history, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager_main!!.adapter = MyPagerAdapter(activity!!.supportFragmentManager)
        tabs_main?.setupWithViewPager(viewpager_main)
    }


}