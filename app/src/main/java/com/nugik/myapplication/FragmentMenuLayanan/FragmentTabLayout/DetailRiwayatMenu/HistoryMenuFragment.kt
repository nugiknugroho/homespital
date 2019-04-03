package com.nugik.myapplication.FragmentMenuLayanan.FragmentTabLayout.DetailRiwayatMenu

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_menu_history.*

class HistoryMenuFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_menu_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cv_riwayat_ambulance?.setOnClickListener {
            val intent = Intent(activity, DetailRiwayatMenu::class.java)
            activity!!.startActivity(intent)
        }
    }
}