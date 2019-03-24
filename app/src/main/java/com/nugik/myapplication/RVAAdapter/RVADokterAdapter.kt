package com.nugik.myapplication.RVAAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.list_dokter.view.*

/**
 * Created by Belal on 6/19/2017.
 */

class RVADokterAdapter(val userList: ArrayList<Dokter>) : RecyclerView.Adapter<RVADokterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVADokterAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_dokter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVADokterAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Dokter) {

            val textViewNamaDokter = itemView.findViewById(R.id.textViewNamaDokter) as TextView
            val textViewSpesialis = itemView.findViewById(R.id.textViewSpesialis) as TextView
            val textViewHarga = itemView.findViewById(R.id.textViewHarga) as TextView
            val textViewStatus = itemView.findViewById(R.id.textViewStatus) as TextView

            textViewNamaDokter.text = user.name
            textViewSpesialis.text = user.spesialis
            textViewHarga.text = user.harga
            textViewStatus.text = user.status
        }
    }
}