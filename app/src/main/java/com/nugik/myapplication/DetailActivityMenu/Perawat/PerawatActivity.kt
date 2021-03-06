package com.nugik.myapplication.DetailActivityMenu.Perawat

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.Data.Perawat
import com.nugik.myapplication.FragmentMenuLayanan.HomeActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVAPerawatAdapter
import kotlinx.android.synthetic.main.activity_perawat.*
import org.json.JSONObject

class PerawatActivity : AppCompatActivity() {

    val users = ArrayList<Perawat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perawat)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        float_home.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }


        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

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

    override fun onResume() {
        super.onResume()
        load_data()
    }

    private fun load_data(){
        val loading = ProgressDialog(this)
        loading.setMessage("Melihat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ_PERAWAT)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        }
                    override fun onResponse(response: JSONObject?) {

                        users.clear()

                        val jsonArray = response?.optJSONArray("result")


                        if(jsonArray?.length() == 0){
                            loading.dismiss()

                             }
//
                        for(i in 0 until jsonArray?.length()!!){

                            val jsonObject = jsonArray?.optJSONObject(i)
                            var pathImg=""
                            if(jsonObject.getString("pp_perawat") == ""){
                                pathImg="https://fahrulakbar.000webhostapp.com/homespital/admin/Homespital/assets/post/dokter/0profil_foto.png"
                            }else {
                                pathImg = "https://fahrulakbar.000webhostapp.com/homespital/admin/Homespital/assets/post/perawat/" + jsonObject.getString("pp_perawat")
                            }
                            users.add(Perawat(jsonObject.getString("nm_perawat"),
                                    jsonObject.getString("alamat_perawat"),
                                    jsonObject.getString("harga"),
                                    jsonObject.getString("status"),pathImg))
                            if(jsonArray?.length() - 1 == i){

                                loading.dismiss()
                                val adapter = RVAPerawatAdapter(applicationContext, users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter = adapter

                            }


                        }
                    }

                })

    }
}
