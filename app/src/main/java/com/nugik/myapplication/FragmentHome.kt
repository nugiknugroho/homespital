package com.nugik.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome :Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        tv_dokter.setOnClickListener {
//            val intent = Intent(this, DokterActivity::class.java)
//            startActivity(intent)
//        }
    }

//    private fun Intent(fragmentHome: FragmentHome, java: Class<DokterActivity>): Intent? {
//
//    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }


}