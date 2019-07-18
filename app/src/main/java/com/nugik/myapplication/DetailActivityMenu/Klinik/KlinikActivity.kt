package com.nugik.myapplication.DetailActivityMenu.Klinik

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.DetailActivityMenu.Dokter.DokterActivity
import com.nugik.myapplication.MapsActivity
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_klinik.*

class KlinikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klinik)

        cv_klinik?.setOnClickListener {
            val intent = Intent(this, DaftarKlinik::class.java)
            startActivity(intent)
        }

        cv_klinik1?.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
