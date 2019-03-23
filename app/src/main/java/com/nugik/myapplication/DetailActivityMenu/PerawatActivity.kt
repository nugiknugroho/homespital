package com.nugik.myapplication.DetailActivityMenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_dokter.*

class PerawatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perawat)

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
