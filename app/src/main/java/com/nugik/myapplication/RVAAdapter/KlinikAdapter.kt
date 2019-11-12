package com.nugik.myapplication.RVAAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.Data.Klinik
import com.nugik.myapplication.DetailActivityMenu.Klinik.KlinikMapsActivity
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.list_klinik.view.*

class KlinikAdapter(val context: Context, val userList: ArrayList<Klinik>) : RecyclerView.Adapter<KlinikAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KlinikAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_klinik, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: KlinikAdapter.ViewHolder, position: Int) {
        holder.itemView.nama_klinik.text = userList?.get(position).nama_klinik
        holder.itemView.alamat_klinik.text = userList?.get(position).alamat_klinik
        holder.itemView.telp_klinik.text = userList?.get(position).no_telp
        holder.itemView.lon.text = userList?.get(position).lon
        holder.itemView.lat.text = userList?.get(position).lat

        holder.itemView.cv_klinik?.setOnClickListener {
            val i = Intent(context, KlinikMapsActivity::class.java)
            i.putExtra("pesan", "1")
            i.putExtra("nm_klinik", userList?.get(position)?.nama_klinik)
            i.putExtra("alamat_klinik", userList?.get(position)?.alamat_klinik)
            i.putExtra("no_telp", userList?.get(position)?.no_telp)
            i.putExtra("lon", userList?.get(position)?.lon)
            i.putExtra("lat", userList?.get(position)?.lat)
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