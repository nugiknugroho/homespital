package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_pesan_dokter.*

class PesanDokter : AppCompatActivity() {

    lateinit var i:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_dokter)

        i = intent

        if(i.hasExtra(  "pesanmode")){

            if(i.getStringExtra("pesanmode").equals("1")){

                onEditMode()

            }

        }

        btn_pesan_dokter.setOnClickListener {

        }
    }

    private fun onEditMode(){

        cobacoba1.setText(i.getStringExtra("nm_dokter"))
        cobacoba2.setText(i.getStringExtra("nm_spesialis"))
        cobacoba3.setText(i.getStringExtra("harga_dokter"))
        cobacoba4.setText(i.getStringExtra("status"))

        cobacoba1.isEnabled = false
        cobacoba2.isEnabled = false
        cobacoba3.isEnabled = false
        cobacoba4.isEnabled = false

     }


}

