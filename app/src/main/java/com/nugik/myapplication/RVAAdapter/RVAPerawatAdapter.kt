package com.nugik.myapplication.RVAAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Perawat
import com.nugik.myapplication.R

class RVAPerawatAdapter(val userList: ArrayList<Perawat>) : RecyclerView.Adapter<RVAPerawatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAPerawatAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_bidan, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAPerawatAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Perawat) {

            val textViewNamaPerawat = itemView.findViewById(R.id.textViewNamaBidan) as TextView
            val textViewAlamat = itemView.findViewById(R.id.textViewAlamat) as TextView
            val textViewHarga = itemView.findViewById(R.id.textViewHarga) as TextView
            val textViewStatus = itemView.findViewById(R.id.textViewStatus) as TextView

            textViewNamaPerawat.text = user.name
            textViewAlamat.text = user.alamat
            textViewHarga.text = user.harga
            textViewStatus.text = user.status
        }
    }
}