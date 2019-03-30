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



    override fun getItemCount(): Int=userList!!.size

    override fun onBindViewHolder(holder: RVADokterAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewNamaDokter.text = userList?.get(position)?.name
        holder.itemView.textViewSpesialis.text = userList?.get(position)?.spesialis
        holder.itemView.textViewHarga.text = userList?.get(position)?.harga
        holder.itemView.textViewStatus.text = userList?.get(position)?.status

//        holder.bindItems(userList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}