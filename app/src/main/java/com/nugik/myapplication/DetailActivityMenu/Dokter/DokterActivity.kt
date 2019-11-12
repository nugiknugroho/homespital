package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.FragmentMenuLayanan.HomeActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVADokterAdapter
import org.json.JSONObject
import kotlinx.android.synthetic.main.activity_dokter.*


class DokterActivity : AppCompatActivity() {

    var users = ArrayList<Dokter>()
    lateinit var adapter: RVADokterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

        //backarrow
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //float
        float_home.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = RVADokterAdapter(this, users)

        recyclerView.adapter = adapter

        cari_dokter.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

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


    override fun onResume() {
        super.onResume()
        load_data()
    }

    private fun load_data(){
        val loading = ProgressDialog(this)
        loading.setMessage("Melihat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ)
                .setPriority(Priority.MEDIUM)
                    .build()
                            .getAsJSONObject(object : JSONObjectRequestListener{
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
                                        var pathImg: String = ""
                                        if(jsonObject.getString("pp_dokter") == ""){
                                            pathImg="http://alfathtech.co.id/homespital/admin/assets/post/dokter/0profil_foto.png"
                                        }else {
                                            pathImg = "http://alfathtech.co.id/homespital/admin/assets/post/dokter/" + jsonObject.getString("pp_dokter")
                                        }
                                        users.add(Dokter(jsonObject.getString("nm_dokter"),
                                                jsonObject.getString("nm_spesialis"),
                                                jsonObject.getString("harga_dokter"),
                                                jsonObject.getString("status"),
                                                jsonObject.getString("id_dokter"),pathImg))
                                        if(jsonArray?.length() - 1 == i){

                                            loading.dismiss()
                                            val adapter = RVADokterAdapter(applicationContext, users)
                                            adapter.notifyDataSetChanged()
                                            recyclerView.adapter = adapter

                                        }


                                    }
                                }

                            })

    }

    fun filter(text: String) {

        val filteredCourseAry: ArrayList<Dokter> = ArrayList()

        val courseAry : ArrayList<Dokter> = users

        for (eachCourse in courseAry) {
            if (eachCourse.name!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.spesialis!!.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(eachCourse)
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredCourseAry)
    }

 }




