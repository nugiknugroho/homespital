package com.nugik.myapplication.DetailActivityMenu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.LinearLayout
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVADokterAdapter
import kotlinx.android.synthetic.main.activity_dokter.*

class DokterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<Dokter>()

        //adding some dummy data to the list
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
        //creating our adapter
        val adapter = RVADokterAdapter(users)

        //now adding the adapter to recyclerview
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




