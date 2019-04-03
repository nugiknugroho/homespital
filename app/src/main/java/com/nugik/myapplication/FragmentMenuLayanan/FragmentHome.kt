package com.nugik.myapplication.FragmentMenuLayanan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.nugik.myapplication.Data.Artikel
import com.nugik.myapplication.DetailActivityMenu.Ambulance.AmbulanceActivity
import com.nugik.myapplication.DetailActivityMenu.Bidan.BidanActivity
import com.nugik.myapplication.DetailActivityMenu.Klinik.KlinikActivity
import com.nugik.myapplication.DetailActivityMenu.Dokter.DokterActivity
import com.nugik.myapplication.DetailActivityMenu.Perawat.PerawatActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVAArtikelAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome :Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayout.HORIZONTAL, false)

        val users = ArrayList<Artikel>()

        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        users.add(Artikel("JUDUL ARTIKEL", "Sebagian isi Konten ...", "KATEGORI"))
        val adapter = RVAArtikelAdapter(users)

        recyclerView.adapter = adapter

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cv_dokter?.setOnClickListener {
            val intent = Intent(activity, DokterActivity::class.java)
            activity!!.startActivity(intent)
        }

        cv_bidan?.setOnClickListener {
            val intent = Intent(activity, BidanActivity::class.java)
            activity!!.startActivity(intent)
        }
        cv_perawat?.setOnClickListener {
            val intent = Intent(activity, PerawatActivity::class.java)
            activity!!.startActivity(intent)
        }
        cv_home_ambulance?.setOnClickListener {
            val intent = Intent(activity, AmbulanceActivity::class.java)
            activity!!.startActivity(intent)
        }
        cv_home_klinik?.setOnClickListener {
            val intent = Intent(activity, KlinikActivity::class.java)
            activity!!.startActivity(intent)
        }
    }
}