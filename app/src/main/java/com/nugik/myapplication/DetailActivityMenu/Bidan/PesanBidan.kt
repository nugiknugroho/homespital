package com.nugik.myapplication.DetailActivityMenu.Bidan

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.FragmentMenuLayanan.HomeActivity
import com.nugik.myapplication.LogRegister.MainActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.LogRegister.SessionManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesan_bidan.*
import kotlinx.android.synthetic.main.activity_pesan_bidan.toolbar
import org.json.JSONObject

class PesanBidan : AppCompatActivity() {

    lateinit var i: Intent
    lateinit var session: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_bidan)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        float_home.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

        i = intent

        if(i.hasExtra(  "pesan")){

            if(i.getStringExtra("pesan").equals("1")){

                onEditMode()

            }

        }

        btn_pesan_bidan.setOnClickListener {
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
        Picasso
                .with(this)
                .load(i.getStringExtra("image"))
                .into(iv_image_bidan)
        tv_namaBidan.setText(i.getStringExtra("nm_bidan"))
        tv_alamatBidan.setText(i.getStringExtra("alamat_bidan"))
        tv_hargaBidan.setText("Rp. " +i.getStringExtra("harga_bidan"))
    }

    private fun onPesan(){
        session = SessionManager(this!!)
        session.checkLogin()

        var user: HashMap<String, String> = session.getUserDetails()
        var id: String = user.get(SessionManager.KEY_ID)!!
        var bidan=i.getStringExtra("id_bidan")
        val loading = ProgressDialog(this)
        loading.setMessage("Mengkonfirmasi Pesanan Anda ...")
        loading.show()
        AndroidNetworking.post(ApiEndPoint.BOOKING)
                .addBodyParameter("booking  ","1")
                .addBodyParameter("id",id)
                .addBodyParameter("id_bidan",bidan)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {

                        loading.dismiss()

                        if(response?.getString("message")?.contains("successfully")!!){
                            val intent = Intent(this@PesanBidan, MainActivity::class.java)
                            startActivity(intent)
                        }

                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                    }


                })


    }
}
