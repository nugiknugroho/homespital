package com.nugik.myapplication.DetailActivityMenu.Bidan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.LinearLayout
import com.nugik.myapplication.Data.Bidan
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVABidanAdapter
import kotlinx.android.synthetic.main.activity_dokter.*

class BidanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bidan)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<Bidan>()

        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))
        users.add(Bidan("Nama Bidan", "Alamat", "Harga", "Status Ketersediaan"))


        val adapter = RVABidanAdapter(users)

        recyclerView.adapter = adapter

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            (android.R.id.home)->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
