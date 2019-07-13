package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.Data.hs_chat
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatChat.DetailRiwayatChat
import com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatMenu.DetailRiwayatMenu
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.list_history.view.*

class RVAChatAdapter(val context: Context, val userList: ArrayList<hs_chat>) : RecyclerView.Adapter<RVAChatAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_history, parent, false)
        return ViewHolder(v)
    }
    //
    //
    // jsnaj

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val id=userList?.get(position).pl
        if(id=="Bidan") {
            holder.itemView.nama_pl.text = userList?.get(position).pl
            holder.itemView.tgl_pemesanan.text = userList?.get(position).tgl
            holder.itemView.status.text = userList?.get(position).status
            holder.itemView.nama.text=userList?.get(position).nama_bidan
        }else if(id=="Perawat"){
            holder.itemView.nama_pl.text = userList?.get(position).pl
            holder.itemView.tgl_pemesanan.text = userList?.get(position).tgl
            holder.itemView.status.text = userList?.get(position).status
            holder.itemView.nama.text=userList?.get(position).nama_perawat
        }else{
            holder.itemView.nama_pl.text = userList?.get(position).pl
            holder.itemView.tgl_pemesanan.text = userList?.get(position).tgl
            holder.itemView.status.text = userList?.get(position).status
        }
        holder.itemView.cv_riwayat.setOnClickListener {
            val i = Intent(context, DetailRiwayatChat::class.java)
            i.putExtra("lihat", 1)
            i.putExtra("id_bidan",userList.get(position).id_bidan)
            i.putExtra("id_perawat",userList.get(position).id_perawat)
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