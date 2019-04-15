package com.nugik.myapplication.DetailActivityMenu.Bidan

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_pesan_bidan.*
import kotlinx.android.synthetic.main.list_bidan.*

class PesanBidan : AppCompatActivity() {

    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_bidan)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        i = intent

        if(i.hasExtra(  "pesan")){

            if(i.getStringExtra("pesan").equals("1")){

                onEditMode()

            }

        }

        btn_pesan_bidan.setOnClickListener {
            onPesan()
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

        tv_namaBidan.setText(i.getStringExtra("nm_bidan"))
        tv_alamatBidan.setText(i.getStringExtra("alamat_bidan"))
        tv_hargaBidan.setText("Rp. " +i.getStringExtra("harga_bidan"))
    }

    private fun onPesan(){

        val loading = ProgressDialog(this)
        loading.setMessage("Mengkonfirmasi Pesanan Anda ...")
        loading.show()



    }
}
