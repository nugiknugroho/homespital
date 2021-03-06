package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.DetailActivityMenu.Dokter.ChatDokter
import com.nugik.myapplication.DetailActivityMenu.Dokter.PesanDokter
import com.nugik.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.list_artikel_horizontal.view.*
import kotlinx.android.synthetic.main.list_dokter.view.*
import kotlinx.android.synthetic.main.list_dokter.view.iv_image_dokter as iv_image_dokter1

/**
 * Created by Belal on 6/19/2017.
 */

class RVADokterAdapter(val context: Context, var userList: ArrayList<Dokter>) : RecyclerView.Adapter<RVADokterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVADokterAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_dokter, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: RVADokterAdapter.ViewHolder, position: Int) {
        Picasso
                .with(context)
                .load(userList?.get(position).image)
                .into(holder.itemView.iv_image_dokter)
        holder.itemView.textViewNamaDokter.text = userList?.get(position)?.name
        holder.itemView.textViewSpesialis.text = userList?.get(position)?.spesialis
        holder.itemView.textViewHarga.text = userList?.get(position)?.harga
        holder.itemView.textViewStatus.text = userList?.get(position)?.status

        holder.itemView.cv_layanan_dokter?.setOnClickListener {
            val i = Intent(context, PesanDokter::class.java)
                i.putExtra("pesan", "1")
                i.putExtra("nm_dokter", userList?.get(position)?.name)
                i.putExtra("nm_spesialis", userList?.get(position)?.spesialis)
                i.putExtra("harga_dokter", userList?.get(position)?.harga)
                i.putExtra("status", userList?.get(position)?.status)
                i.putExtra("id_dokter", userList?.get(position)?.id)
                i.putExtra("image", userList?.get(position)?.image)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }
        // holder.bindItems(userList[position])
    }

    fun filterList(filteredDokterList : ArrayList<Dokter>){
        this.userList = filteredDokterList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }


}

