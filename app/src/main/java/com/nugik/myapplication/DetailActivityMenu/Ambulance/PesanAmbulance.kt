package com.nugik.myapplication.DetailActivityMenu.Ambulance

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.FragmentMenuLayanan.HomeActivity
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_pesan_ambulance.*

class PesanAmbulance : AppCompatActivity() {

    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_ambulance)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        float_home.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

        i = intent

        if(i.hasExtra(  "pesan")){

            if(i.getStringExtra("pesan").equals("1")){

                onEditMode()

            }

        }

        btn_pesan_ambulance.setOnClickListener {
            onPesanAmbulance()
        }
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

    private fun onEditMode(){

        tv_noplat.setText(i.getStringExtra("plat_ambulance"))
        tv_alamatklinikambulance.setText(i.getStringExtra("alamat_ambulance"))
        tv_kota_klinikambulance.setText(i.getStringExtra("kota"))
        tv_tujuanKlinik.setText(i.getStringExtra("alamat_ambulance"))
    }

    private fun onPesanAmbulance(){
        val loading = ProgressDialog(this)
        loading.setMessage("Mengkonfirmasi Pesanan Anda ...")
        loading.show()
    }

}
