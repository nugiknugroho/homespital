package com.nugik.myapplication.DetailActivityMenu.Bidan

import android.app.ProgressDialog
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
import com.nugik.myapplication.Data.Bidan
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVABidanAdapter
import kotlinx.android.synthetic.main.activity_bidan.*
import org.json.JSONObject

class BidanActivity : AppCompatActivity() {

    val users = ArrayList<Bidan>()
//    lateinit var session: Sessionbidan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bidan)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

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

        AndroidNetworking.get(ApiEndPoint.READ_BIDAN)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(response: JSONObject?) {

                        users.clear()

                        val jsonArray = response?.optJSONArray("result")


                        if(jsonArray?.length() == 0){
                            loading.dismiss()
                            Toast.makeText(applicationContext," data is empty, Add the data first", Toast.LENGTH_SHORT).show()
                        }
//
                        for(i in 0 until jsonArray?.length()!!){

                            val jsonObject = jsonArray?.optJSONObject(i)
//                            session.Sessionbidan(jsonObject.getString("id_bidan"))
                            users.add(Bidan( jsonObject.getString("nm_bidan"),
                                    jsonObject.getString("alamat_bidan"),
                                    jsonObject.getString("harga_bidan"),
                                    jsonObject.getString("status"),
                                    jsonObject.getString("id_bidan")))
                            if(jsonArray?.length() - 1 == i){

                                loading.dismiss()
                                val adapter = RVABidanAdapter(applicationContext, users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter = adapter

                            }


                        }
                    }

                })

    }
}
