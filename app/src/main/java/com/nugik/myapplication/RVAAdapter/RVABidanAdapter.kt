package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Bidan
import com.nugik.myapplication.DetailActivityMenu.Bidan.PesanBidan
import com.nugik.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.list_bidan.view.*
import kotlinx.android.synthetic.main.fragment_home.view.iv_image_bidan as iv_image_bidan1

class RVABidanAdapter(val context: Context, val userList: ArrayList<Bidan>) : RecyclerView.Adapter<RVABidanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVABidanAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_bidan, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVABidanAdapter.ViewHolder, position: Int) {
        Picasso
                .with(context)
                .load(userList?.get(position).image)
                .into(holder.itemView.iv_image_bidan)
        holder.itemView.textViewNamaBidan.text = userList?.get(position)?.name
        holder.itemView.textViewAlamat.text = userList?.get(position)?.alamat
        holder.itemView.textViewHarga.text = userList?.get(position)?.harga
        holder.itemView.textViewStatus.text = userList?.get(position)?.status
        holder.itemView.cv_layanan_bidan?.setOnClickListener {
            val i = Intent(context, PesanBidan::class.java)
            i.putExtra("pesan", "1")
            i.putExtra("nm_bidan", userList?.get(position)?.name)
            i.putExtra("alamat_bidan", userList?.get(position)?.alamat)
            i.putExtra("harga_bidan", userList?.get(position)?.harga)
            i.putExtra("status", userList?.get(position)?.status)
            i.putExtra("id_bidan", userList.get(position)?.id)
            i.putExtra("image", userList.get(position)?.image)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }
        //holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        fun bindItems(user: Bidan) {
//
//            val textViewNamaBidan = itemView.findViewById(R.id.textViewNamaBidan) as TextView
//            val textViewAlamat = itemView.findViewById(R.id.textViewAlamat) as TextView
//            val textViewHarga = itemView.findViewById(R.id.textViewHarga) as TextView
//            val textViewStatus = itemView.findViewById(R.id.textViewStatus) as TextView
//
//            textViewNamaBidan.text = user.name
//            textViewAlamat.text = user.alamat
//            textViewHarga.text = user.harga
//            textViewStatus.text = user.status
//        }
    }


}