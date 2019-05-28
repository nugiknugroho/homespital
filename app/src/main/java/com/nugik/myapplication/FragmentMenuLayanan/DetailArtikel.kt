package com.nugik.myapplication.FragmentMenuLayanan

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_detail_artikel.*

class DetailArtikel : AppCompatActivity() {

    lateinit var i: Intent



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        i = intent

        if(i.hasExtra(  "lihat")){

            if(i.getStringExtra("lihat").equals("1")){

                onEditMode()

            }

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

        tv_detail_judul.setText(i.getStringExtra("title"))
        tv_detail_kategori.setText(i.getStringExtra("nama_kategori"))
        tv_detail_isi.setText(i.getStringExtra("content"))
    }
}
