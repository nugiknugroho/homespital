package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.Data.Artikel
import com.nugik.myapplication.Data.history
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatMenu.DetailRiwayatMenu
//import com.nugik.myapplication.FragmentMenuLayanan.DetailArtikel
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_menu_history.view.*
import kotlinx.android.synthetic.main.list_history.view.*

//import kotlinx.android.synthetic.main.list_artikel.view.*

class RVAHistoryAdapter(val context: Context, val userList: ArrayList<history>) : RecyclerView.Adapter<RVAHistoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_history, parent, false)
        return ViewHolder(v)
    }
    //jsnaj

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.nama_pl.text = userList?.get(position).pl
        holder.itemView.tgl_pemesanan.text = userList?.get(position).tgl
        holder.itemView.status.text=userList?.get(position).status
        holder.itemView.cv_riwayat.setOnClickListener {
            val i = Intent(context, DetailRiwayatMenu::class.java)
            i.putExtra("lihat", "1")
            i.putExtra("nama_pl", userList?.get(position)?.pl)
            i.putExtra("tanggal", userList?.get(position)?.tgl)
            i.putExtra("id", userList?.get(position)?.id)
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