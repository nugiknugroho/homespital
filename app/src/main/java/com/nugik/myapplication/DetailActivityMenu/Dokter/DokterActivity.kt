package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVADokterAdapter
import kotlinx.android.synthetic.main.activity_dokter.*
import org.json.JSONObject

class DokterActivity : AppCompatActivity() {
    val users = ArrayList<Dokter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user


        //adding some dummy data to the list
//        users.add(Dokter("fafa", "dokter gigi", "Rp.50000", "available"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
////        users.add(Dokter("Nama Dokter", "Spesialis", "Harga", "Status Ketersediaan"))
//        //creating our adapter
//        val adapter = RVADokterAdapter(users)
//
//        //now adding the adapter to recyclerview
//        recyclerView.adapter = adapter
    }
    override fun onResume() {
        super.onResume()
        loadAllStudents()
    }
    private fun loadAllStudents(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {

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
                            users.add(Dokter(jsonObject.getString("nm_dokter"), jsonObject.getString("nm_dokter"), jsonObject.getString("harga_dokter"), jsonObject.getString("username_dokter")))
//                            users.add(Dokter(jsonObject.getString("nm_dokter"), jsonObject.getString("nm_dokter"), jsonObject.getString("harga"), jsonObject.getString("username_dokter")))
//                            users.add(Dokter(jsonObject.getString("nm_dokter"), jsonObject.getString("alamat"), jsonObject.getString("pp_dokter"), jsonObject.getString("nm_dokter")))
//
                            if(jsonArray?.length() - 1 == i){

                                loading.dismiss()
                                val adapter = RVADokterAdapter(users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter = adapter

                            }


                    }
                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                    }
                })


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




