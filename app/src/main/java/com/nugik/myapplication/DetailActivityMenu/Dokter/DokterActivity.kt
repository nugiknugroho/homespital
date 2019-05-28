package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.app.ProgressDialog
import android.util.Log
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.Data.Dokter
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVADokterAdapter
import org.json.JSONObject
import kotlinx.android.synthetic.main.activity_dokter.*


class DokterActivity : AppCompatActivity() {
    val users = ArrayList<Dokter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

        //backarrow
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


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

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        val searchItem = menu?.findItem(R.id.menu_search)
//
//        if (searchItem != null){
//            val searchView = searchItem.actionView as SearchView
//            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    return true
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    return true
//                }
//
//            })
//        }
//
//        return super.onCreateOptionsMenu(menu)
//    }

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
                                        users.add(Dokter(jsonObject.getString("nm_dokter"),
                                                jsonObject.getString("nm_spesialis"),
                                                jsonObject.getString("harga_dokter"),
                                                jsonObject.getString("status"),
                                                jsonObject.getString("id_dokter")))
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



 }




