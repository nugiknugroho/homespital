package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.LogRegister.MainActivity
import com.nugik.myapplication.LogRegister.SessionManager
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_pesan_dokter.*
import org.json.JSONObject

class PesanDokter : AppCompatActivity() {

    lateinit var i:Intent
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_dokter)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        i = intent

        if(i.hasExtra(  "pesan")){

            if(i.getStringExtra("pesan").equals("1")){

                onEditMode()

            }

        }

        btn_pesan_dokter.setOnClickListener {
            onPesan()
        }
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

    private fun onEditMode(){

        tv_namaDokter.setText(i.getStringExtra("nm_dokter"))
        tv_spesialisDokter.setText(i.getStringExtra("nm_spesialis"))
        tv_hargaDokter.setText("Rp. " +i.getStringExtra("harga_dokter"))
        tot_bayar_dokter.setText("Rp. " +i.getStringExtra("harga_dokter"))
     }
    private fun onPesan(){
        session = SessionManager(this!!)
        session.checkLogin()

        var user: HashMap<String, String> = session.getUserDetails()
        var id: String = user.get(SessionManager.KEY_ID)!!
        var dokter=i.getStringExtra("id_dokter")
        val loading = ProgressDialog(this)
        loading.setMessage("Mengkonfirmasi Pesanan Anda ...")
        loading.show()
        AndroidNetworking.post(ApiEndPoint.BOOKING)
                .addBodyParameter("booking","2")
                .addBodyParameter("id",id)
                .addBodyParameter("id_dokter",dokter)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {

                        loading.dismiss()
                        Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()

                        if(response?.getString("message")?.contains("successfully")!!){
                            val intent = Intent(this@PesanDokter, MainActivity::class.java)
                            startActivity(intent)
                        }

                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext,"Koneksi Gagal", Toast.LENGTH_SHORT).show()                    }


                })


    }


}

