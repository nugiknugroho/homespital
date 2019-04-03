package com.nugik.myapplication.LogRegister

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.app.DatePickerDialog
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONObject
import java.util.*

class Main2Activity : AppCompatActivity() {

    lateinit var i:Intent
    private var jk="1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        tv_date.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {

                view, year, monthOfYear, dayOfMonth ->
                tv_date.setText(""+year+"-"+(monthOfYear+1)+"-"+dayOfMonth)

            }, year, month, day)
            dpd.show()
        }


        val button = findViewById(R.id.btn_daftar) as Button
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            register()
        }

        rg_gender.setOnCheckedChangeListener{ radioGroup, i ->

            when(i){

                R.id.rb_laki ->{
                    jk = "1"
                }

                R.id.rb_cewek ->{
                    jk = "2"
                }

            }

        }
    }

    private fun register(){

        val loading = ProgressDialog(this)
        loading.setMessage("Mendaftarkan Diri ...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.CREATE)
                .addBodyParameter("nama",edt_nama_lengkap.text.toString())
                .addBodyParameter("email",email.text.toString())
                .addBodyParameter("gender",jk)
                .addBodyParameter("kotaasal",edt_kotaasal.text.toString())
                .addBodyParameter("alamat",edt_alamat.text.toString())
                .addBodyParameter("ttl",tv_date.text.toString())
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


