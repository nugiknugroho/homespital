package com.nugik.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {



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
     }
    private fun load_data(){


        AndroidNetworking.post(ApiEndPoint.READ_LOGIN)
                .addBodyParameter("username",username.text.toString())
                .addBodyParameter("password",password.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {

                    override fun onResponse(response: JSONObject?) {


                        if(response?.getString("message")?.contains("successfully")!!){

                            val intent = Intent(this@MainActivity, HomeActivity::class.java)
                            startActivity(intent)

                            this@MainActivity.finish()

                        }else{
                            Toast.makeText(applicationContext,"SignIn Gagal", Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onError(anError: ANError?) {
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }


                })




    }


}
