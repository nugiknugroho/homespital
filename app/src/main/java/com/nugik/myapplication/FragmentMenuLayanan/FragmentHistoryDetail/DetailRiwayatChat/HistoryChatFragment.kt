package com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatChat

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_chat_history.*

class HistoryChatFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_chat_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cv_riwayat_dokter?.setOnClickListener {
            val intent = Intent(activity, DetailRiwayatChat::class.java)
            activity!!.startActivity(intent)
        }
    }

}