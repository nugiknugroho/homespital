package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.Data.Artikel
import com.nugik.myapplication.FragmentMenuLayanan.DetailArtikel
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.list_artikel_horizontal.view.textViewJudulArtikel
import kotlinx.android.synthetic.main.list_artikel_horizontal.view.textViewKategori
import kotlinx.android.synthetic.main.list_artikel_horizontal.view.*

class ArtikelHorizontalAdapter(val context: Context, val userList: ArrayList<Artikel>) : RecyclerView.Adapter<ArtikelHorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelHorizontalAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_artikel_horizontal, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ArtikelHorizontalAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewJudulArtikel.text = userList?.get(position).judul
        holder.itemView.textViewKategori.text = userList?.get(position).kategori

        holder.itemView.artikel2.setOnClickListener {
            val i = Intent(context, DetailArtikel::class.java)
            i.putExtra("lihat", "1")
            i.putExtra("title", userList?.get(position)?.judul)
            i.putExtra("nama_kategori", userList?.get(position)?.kategori)
            i.putExtra("content", userList?.get(position)?.isi)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }
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