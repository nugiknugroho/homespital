package com.nugik.myapplication.FragmentMenuLayanan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.nugik.myapplication.Data.Artikel
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVAArtikelAdapter

class FragmentArticle :Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_article, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)

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



}