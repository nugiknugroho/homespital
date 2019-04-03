package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Perawat
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.list_perawat.view.*

class RVAPerawatAdapter(val context: Context, val userList: ArrayList<Perawat>) : RecyclerView.Adapter<RVAPerawatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAPerawatAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_perawat, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAPerawatAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewNamaPerawat.text = userList?.get(position)?.name
        holder.itemView.textViewAlamat.text = userList?.get(position)?.alamat
        holder.itemView.textViewHarga.text = userList?.get(position)?.harga
        holder.itemView.textViewStatus.text = userList?.get(position)?.status
        //holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        fun bindItems(user: Perawat) {
//
//            val textViewNamaPerawat = itemView.findViewById(R.id.textViewNamaBidan) as TextView
//            val textViewAlamat = itemView.findViewById(R.id.textViewAlamat) as TextView
//            val textViewHarga = itemView.findViewById(R.id.textViewHarga) as TextView
//            val textViewStatus = itemView.findViewById(R.id.textViewStatus) as TextView
//
//            textViewNamaPerawat.text = user.name
//            textViewAlamat.text = user.alamat
//            textViewHarga.text = user.harga
//            textViewStatus.text = user.status
//        }
    }
}