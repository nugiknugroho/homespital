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

        tv_namaDokter.setText(i.getStringExtra("nm_dokter"))
        tv_spesialisDokter.setText(i.getStringExtra("nm_spesialis"))
        tv_hargaDokter.setText(i.getStringExtra("harga_dokter"))

     }


}

