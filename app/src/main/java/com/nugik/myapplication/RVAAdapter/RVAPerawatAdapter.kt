package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nugik.myapplication.Data.Perawat
import com.nugik.myapplication.DetailActivityMenu.Perawat.PesanPerawat
import com.nugik.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_artikel.view.*
import kotlinx.android.synthetic.main.list_perawat.view.*

class RVAPerawatAdapter(val context: Context, val userList: ArrayList<Perawat>) : RecyclerView.Adapter<RVAPerawatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAPerawatAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_perawat, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAPerawatAdapter.ViewHolder, position: Int) {
        Picasso
                .with(context)
                .load(userList?.get(position).image)
                .into(holder.itemView.iv_image_perawat)
        holder.itemView.textViewNamaPerawat.text = userList?.get(position)?.name
        holder.itemView.textViewAlamat.text = userList?.get(position)?.alamat
        holder.itemView.textViewHarga.text = userList?.get(position)?.harga
        holder.itemView.textViewStatus.text = userList?.get(position)?.status
        holder.itemView.cv_layanan_perawat?.setOnClickListener {
            val i = Intent(context, PesanPerawat::class.java)
            i.putExtra("pesan", "1")
            i.putExtra("nm_perawat", userList?.get(position)?.name)
            i.putExtra("alamat_perawat", userList?.get(position)?.alamat)
            i.putExtra("harga", userList?.get(position)?.harga)
            i.putExtra("status", userList?.get(position)?.status)
            i.putExtra("image", userList?.get(position)?.image)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }
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