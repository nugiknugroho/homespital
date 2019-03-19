package com.nugik.myapplication

import android.app.ProgressDialog
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
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONObject

class Main2Activity : AppCompatActivity() {
    lateinit var i:Intent
    private var jk="1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val button = findViewById(R.id.btn_daftar) as Button
        button.setOnClickListener {
            register()
        }





           gender.setOnCheckedChangeListener{ radioGroup, i ->

            when(i){

                R.id.laki->{
                    jk = "1"
                }

                R.id.cewek->{
                    jk = "2"
                }

            }

        }



        }


    private fun register(){

        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.CREATE)
                .addBodyParameter("nama",nama.text.toString())
                .addBodyParameter("email",email.text.toString())
                .addBodyParameter("gender",jk)
                .addBodyParameter("alamat",alamat.text.toString())
                .addBodyParameter("ttl",ttl.text.toString())
                .addBodyParameter("username",username.text.toString())
                .addBodyParameter("password",password.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {

                    override fun onResponse(response: JSONObject?) {

                        loading.dismiss()
                        Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()

                        if(response?.getString("message")?.contains("successfully")!!){
                            val intent = Intent(this@Main2Activity, MainActivity::class.java)
                            startActivity(intent)
                        }

                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }


                })

    }
}


