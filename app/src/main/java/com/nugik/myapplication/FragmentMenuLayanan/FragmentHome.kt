package com.nugik.myapplication.FragmentMenuLayanan

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.Data.Artikel
import com.nugik.myapplication.DetailActivityMenu.Ambulance.AmbulanceActivity
import com.nugik.myapplication.DetailActivityMenu.Bidan.BidanActivity
import com.nugik.myapplication.DetailActivityMenu.Klinik.KlinikActivity
import com.nugik.myapplication.DetailActivityMenu.Dokter.DokterActivity
import com.nugik.myapplication.DetailActivityMenu.Klinik.KlinikMapsActivity
import com.nugik.myapplication.DetailActivityMenu.Perawat.PerawatActivity
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVAArtikelAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONObject

class FragmentHome :Fragment(){

    val users = ArrayList<Artikel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayout.HORIZONTAL, false)

        return view
    }

    override fun onResume() {
        super.onResume()
        load_data()
    }

    private fun load_data(){
        val loading = ProgressDialog(context)
        loading.setMessage("Melihat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ_ARTIKEL)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ONERROR",anError?.errorDetail?.toString())
                        Toast.makeText(context,"Connection Failure", Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(response: JSONObject?) {

                        users.clear()

                        val jsonArray = response?.optJSONArray("result")


                        if(jsonArray?.length() == 0){
                            loading.dismiss()
                            Toast.makeText(context," data is empty, Add the data first", Toast.LENGTH_SHORT).show()
                        }
//
                        for(i in 0 until jsonArray?.length()!!){

                            val jsonObject = jsonArray?.optJSONObject(i)
                            users.add(Artikel(jsonObject.getString("title"),
                                    jsonObject.getString("content"),
                                    jsonObject.getString("nama_kategori")))

                            if(jsonArray?.length() - 1 == i){

                                loading.dismiss()
                                val adapter = RVAArtikelAdapter(context!!, users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter = adapter

                            }


                        }
                    }

                })

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cv_dokter?.setOnClickListener {
            val intent = Intent(activity, DokterActivity::class.java)
            activity!!.startActivity(intent)
        }

        cv_bidan?.setOnClickListener {
            val intent = Intent(activity, BidanActivity::class.java)
            activity!!.startActivity(intent)
        }
        cv_perawat?.setOnClickListener {
            val intent = Intent(activity, PerawatActivity::class.java)
            activity!!.startActivity(intent)
        }
        cv_home_ambulance?.setOnClickListener {
            val intent = Intent(activity, AmbulanceActivity::class.java)
            activity!!.startActivity(intent)
        }
        cv_home_klinik?.setOnClickListener {
            val intent = Intent(activity, KlinikActivity::class.java)
            activity!!.startActivity(intent)
        }
    }
}