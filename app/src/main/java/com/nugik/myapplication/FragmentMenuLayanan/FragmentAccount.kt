package com.nugik.myapplication.FragmentMenuLayanan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.LogRegister.MainActivity
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_account.*

class FragmentAccount :Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_logout?.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            activity!!.startActivity(intent)
        }

    }
}
