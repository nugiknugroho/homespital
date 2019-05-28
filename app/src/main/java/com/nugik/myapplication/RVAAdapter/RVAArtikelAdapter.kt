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
import kotlinx.android.synthetic.main.list_artikel.view.*

class RVAArtikelAdapter(val context: Context, val userList: ArrayList<Artikel>) : RecyclerView.Adapter<RVAArtikelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAArtikelAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_artikel, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAArtikelAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewJudulArtikel.text = userList?.get(position).judul
        holder.itemView.textViewKategori.text = userList?.get(position).kategori

        holder.itemView.cv_artikel.setOnClickListener {
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