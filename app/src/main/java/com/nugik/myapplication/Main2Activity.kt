package com.nugik.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.app.DatePickerDialog
import android.widget.DatePicker
import java.text.SimpleDateFormat
import android.view.View
import android.support.annotation.RequiresApi
import android.widget.Toast
import android.os.Build
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    var edit_Date: EditText? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById(R.id.btn_daftar) as Button
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun ClickDate(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
            view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in Toast
            tv_date.setText(""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year)
            Toast.makeText(this, """$dayOfMonth - ${monthOfYear + 1} - $year""", Toast.LENGTH_LONG).show()
        }, year, month, day)

        dpd.show()
    }

}

