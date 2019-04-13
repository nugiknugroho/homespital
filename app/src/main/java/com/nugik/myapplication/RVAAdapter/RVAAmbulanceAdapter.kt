package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Ambulance
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.DetailActivityMenu.Ambulance.PesanAmbulance
import com.nugik.myapplication.DetailActivityMenu.Dokter.PesanDokter
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.list_ambulance.view.*

/**
 * Created by Belal on 6/19/2017.
 */

class RVAAmbulanceAdapter(val context: Context, val userList: ArrayList<Ambulance>) : RecyclerView.Adapter<RVAAmbulanceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAAmbulanceAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_ambulance, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: RVAAmbulanceAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewNoPlat.text = userList?.get(position)?.no_plat
        holder.itemView.textViewAlamat.text = userList?.get(position)?.alamat_klinik
        holder.itemView.textViewKota.text = userList?.get(position)?.kota
        holder.itemView.textViewStatus.text = userList?.get(position)?.status

        holder.itemView.cv_layanan_ambulance?.setOnClickListener {
            val i = Intent(context, PesanAmbulance::class.java)
            i.putExtra("pesan", "1")
            i.putExtra("plat_ambulance", userList?.get(position)?.no_plat)
            i.putExtra("alamat_ambulance", userList?.get(position)?.alamat_klinik)
            i.putExtra("kota", userList?.get(position)?.kota)
            i.putExtra("status", userList?.get(position)?.status)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }
        // holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}