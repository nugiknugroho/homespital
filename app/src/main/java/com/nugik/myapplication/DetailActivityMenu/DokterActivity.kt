package com.nugik.myapplication.DetailActivityMenu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_dokter.*

class DokterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

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

