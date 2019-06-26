package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_pesan_dokter.*

class PesanDokter : AppCompatActivity() {

    lateinit var i:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_dokter)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        i = intent

        if(i.hasExtra(  "pesan")){

            if(i.getStringExtra("pesan").equals("1")){

                onEditMode()

            }

        }

        btn_pesan_dokter.setOnClickListener {
            val intent = Intent(this, ChatDokter::class.java)
            intent.putExtra("id_dokter",i.getStringExtra("id_dokter"))
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            (android.R.id.home)->{
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun onEditMode(){

        tv_namaDokter.setText(i.getStringExtra("nm_dokter"))
        tv_spesialisDokter.setText(i.getStringExtra("nm_spesialis"))
        tv_hargaDokter.setText("Rp. " +i.getStringExtra("harga_dokter"))
        tot_bayar_dokter.setText("Rp. " +i.getStringExtra("harga_dokter"))
     }


}

