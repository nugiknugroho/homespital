package com.nugik.myapplication.DetailActivityMenu.Klinik

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
import com.nugik.myapplication.Data.Klinik
import com.nugik.myapplication.FragmentMenuLayanan.HomeActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.KlinikAdapter
import kotlinx.android.synthetic.main.activity_daftar_klinik.*
import kotlinx.android.synthetic.main.activity_klinik.toolbar
import org.json.JSONObject

class DaftarKlinik : AppCompatActivity() {

    val users = ArrayList<Klinik>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_klinik)

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
        when (item?.itemId) {
            (android.R.id.home) -> {
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

    private fun load_data() {
        val loading = ProgressDialog(this)
        loading.setMessage("Melihat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ_KLINIK)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR", anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext, "Connection Failure", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(response: JSONObject?) {

                        users.clear()

                        val jsonArray = response?.optJSONArray("result")


                        if (jsonArray?.length() == 0) {
                            loading.dismiss()
                            Toast.makeText(applicationContext, " data is empty, Add the data first", Toast.LENGTH_SHORT).show()
                        }
//
                        for (i in 0 until jsonArray?.length()!!) {

                            val jsonObject = jsonArray?.optJSONObject(i)
                            users.add(Klinik(jsonObject.getString("nm_klinik"),
                                    jsonObject.getString("alamat_klinik"),
                                    jsonObject.getString("no_telp"),
                                    jsonObject.getString("lon"),
                                    jsonObject.getString("lat")))
                            if (jsonArray?.length() - 1 == i) {

                                loading.dismiss()
                                val adapter = KlinikAdapter(applicationContext, users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter = adapter

                            }


                        }
                    }

                })

    }
}
