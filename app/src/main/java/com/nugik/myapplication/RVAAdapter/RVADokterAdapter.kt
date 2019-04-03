package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.DetailActivityMenu.Dokter.PesanDokter
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.list_dokter.view.*

/**
 * Created by Belal on 6/19/2017.
 */

class RVADokterAdapter(val context: Context, val userList: ArrayList<Dokter>) : RecyclerView.Adapter<RVADokterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVADokterAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_dokter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVADokterAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewNamaDokter.text = userList?.get(position)?.name
        holder.itemView.textViewSpesialis.text = userList?.get(position)?.spesialis
        holder.itemView.textViewHarga.text = userList?.get(position)?.harga
        holder.itemView.textViewStatus.text = userList?.get(position)?.status

//        holder.itemView.cv_dokter.setOnClickListener {
//            val i = Intent(context, PesanDokter::class.java)
//            context.startActivity(i)
//        }
        // holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            v!!.context.startActivity(Intent(v.context, PesanDokter::class.java))
        }
    }
}