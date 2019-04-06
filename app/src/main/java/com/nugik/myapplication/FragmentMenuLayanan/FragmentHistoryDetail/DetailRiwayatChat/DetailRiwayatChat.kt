package com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatChat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.R
import com.nugik.myapplication.TabLayoutAdapter.DetailTabPagerAdapter
import kotlinx.android.synthetic.main.activity_ambulance.*
import kotlinx.android.synthetic.main.fragment_history.*

class DetailRiwayatChat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_riwayat_chat)

        viewpager_main!!.adapter = DetailTabPagerAdapter(supportFragmentManager)
        tabs_main?.setupWithViewPager(viewpager_main)

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
