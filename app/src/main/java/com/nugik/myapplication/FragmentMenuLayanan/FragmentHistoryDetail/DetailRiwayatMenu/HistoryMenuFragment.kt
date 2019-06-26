package com.nugik.myapplication.FragmentMenuLayanan.FragmentHistoryDetail.DetailRiwayatMenu

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
import com.nugik.myapplication.Data.history
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.RVAHistoryAdapter
import kotlinx.android.synthetic.main.fragment_menu_history.*
import org.json.JSONObject

class HistoryMenuFragment : Fragment(){
    val users = ArrayList<history>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_menu_history, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cv_menu_riwayat?.setOnClickListener {
            val intent = Intent(activity, DetailRiwayatMenu::class.java)
            activity!!.startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        load_data()
    }

    private fun load_data(){
        val loading = ProgressDialog(context)
        loading.setMessage("Melihat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.HISTORY)
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

                        for(i in 0 until jsonArray?.length()!!){

                            val jsonObject = jsonArray?.optJSONObject(i)
                            users.add(history(jsonObject.getString("nama_pl"),
                                    jsonObject.getString("tanggal_pesan"),
                                    jsonObject.getString("status"),
                                    jsonObject.getString("kode_pesanan")))

                            if(jsonArray?.length() - 1 == i){

                                loading.dismiss()
                                val adapter = RVAHistoryAdapter(context!!, users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter= adapter

                            }


                        }
                    }

                })

    }
}