package com.nugik.myapplication.FragmentMenuLayanan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.DetailActivityMenu.BidanActivity
import com.nugik.myapplication.DetailActivityMenu.DokterActivity
import com.nugik.myapplication.DetailActivityMenu.PerawatActivity
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome :Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lin_dokter?.setOnClickListener {
            val intent = Intent(activity, DokterActivity::class.java)
            activity!!.startActivity(intent)
        }

        lin_bidan?.setOnClickListener {
            val intent = Intent(activity, BidanActivity::class.java)
            activity!!.startActivity(intent)
        }

        lin_nurse?.setOnClickListener {
            val intent = Intent(activity, PerawatActivity::class.java)
            activity!!.startActivity(intent)
        }
    }
}