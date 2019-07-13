package com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatMenu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.Data.history
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVAHistoryAdapter
import kotlinx.android.synthetic.main.activity_ambulance.*
import kotlinx.android.synthetic.main.activity_ambulance.recyclerView
import kotlinx.android.synthetic.main.activity_ambulance.toolbar
import kotlinx.android.synthetic.main.activity_pesan_bidan.*
import kotlinx.android.synthetic.main.fragment_menu_history.*
import org.json.JSONObject

class DetailRiwayatMenu : AppCompatActivity() {
    lateinit var i: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        i=intent
        val tes=i.getStringExtra("nama_pl")
        val id_bidan=i.getStringExtra("id_bidan")
        if(tes=="Bidan") {
            setContentView(R.layout.activity_detail_riwayat_bidan)
            AndroidNetworking.post(ApiEndPoint.TAMPIL_DETAIL)
                    .addBodyParameter("kode","Bidan")
                    .addBodyParameter("id_bidan",id_bidan)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(object : JSONObjectRequestListener {
                        override fun onError(anError: ANError?) {
                            Log.d("ONERROR",anError?.errorDetail?.toString())
                            Toast.makeText(this@DetailRiwayatMenu,"Connection Failure", Toast.LENGTH_SHORT).show()
                        }
                        override fun onResponse(response: JSONObject?) {
                            val jsonArray = response?.optJSONArray("result")


                            if(jsonArray?.length() == 0){
                                Toast.makeText(this@DetailRiwayatMenu," data is empty, Add the data first", Toast.LENGTH_SHORT).show()
                            }

                            for(i in 0 until jsonArray?.length()!!){

                                val jsonObject = jsonArray?.optJSONObject(i)

                                tv_namaBidan.setText(jsonObject.getString("nm_bidan"))
                                tv_alamatBidan.setText(jsonObject.getString("alamat_bidan"))
                                tv_hargaBidan.setText("Rp. " +jsonObject.getString("harga_bidan"))

                                if(jsonArray?.length() - 1 == i){
                                    tv_namaBidan.setText(jsonObject.getString("nm_bidan"))
                                    tv_alamatBidan.setText(jsonObject.getString("alamat_bidan"))
                                    tv_hargaBidan.setText("Rp. " +jsonObject.getString("harga_bidan"))

                                }


                            }
                        }

                    })
        }else{
            setContentView(R.layout.activity_detail_riwayat_menu)
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
