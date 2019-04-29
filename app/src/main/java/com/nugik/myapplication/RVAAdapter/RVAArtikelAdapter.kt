package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.Data.Artikel
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.list_artikel.view.*

class RVAArtikelAdapter(val userList: ArrayList<Artikel>) : RecyclerView.Adapter<RVAArtikelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAArtikelAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_artikel, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAArtikelAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewJudulArtikel.text = userList?.get(position).judul
        holder.itemView.textViewKategori.text = userList?.get(position).kategori
//        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        fun bindItems(user: Artikel) {
//
//            itemView.textViewJudulArtikel?.text = user.judul
//            itemView.textViewKategori?.text = user.kategori
//

//        }
    }
}