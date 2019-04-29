package com.nugik.myapplication.LogRegister

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.Data.Bidan
import com.nugik.myapplication.FragmentMenuLayanan.HomeActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVABidanAdapter
import kotlinx.android.synthetic.main.activity_bidan.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.btn_register) as Button
        button.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        val button1 = findViewById(R.id.btn_login) as Button
        button1.setOnClickListener {
            load_data()
        }

        session = SessionManager(applicationContext)
        if (session.isLoggedIn()){
            var i:Intent = Intent(applicationContext, HomeActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }
    }

    private fun load_data() {


        AndroidNetworking.post(ApiEndPoint.READ_LOGIN)
                .addBodyParameter("username", edt_email.text.toString())
                .addBodyParameter("password", edt_password.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {

                    override fun onResponse(response: JSONObject?) {

                        if (response?.getString("message")?.contains("successfully")!!) {

                            val jsonArray = response?.getJSONObject("user")
//                            Toast.makeText(applicationContext, " ISI = "+jsonArray.toString(), Toast.LENGTH_SHORT).show()
//                            for(i in 0 until jsonArray.length()){
                                val email = jsonArray?.getString("email_user")
                                val id= jsonArray?.getInt("id_user")
                                session.createLoginSession(jsonArray?.getString("username").toString(), email.toString(), id.toString())
                                Toast.makeText(applicationContext, "Login Sukses !!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                                startActivity(intent)

//                            }


                        } else {
                            Toast.makeText(applicationContext, "Login Gagal \n Email / Password Salah", Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onError(anError: ANError?) {
                        Log.d("ONERROR", anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext, "Koneksi Gagal, Coba Lagi", Toast.LENGTH_SHORT).show()
                    }


                })

    }
}



