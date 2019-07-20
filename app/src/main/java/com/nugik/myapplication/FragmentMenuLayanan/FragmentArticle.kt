package com.nugik.myapplication.FragmentMenuLayanan

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
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
import com.nugik.myapplication.R
import com.nugik.myapplication.RVAAdapter.ArtikelHorizontalAdapter
import com.nugik.myapplication.RVAAdapter.RVAArtikelAdapter
import kotlinx.android.synthetic.main.activity_dokter.*
import org.json.JSONObject

class FragmentArticle :Fragment(){

    val users = ArrayList<Artikel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_article, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

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
                    }
                    override fun onResponse(response: JSONObject?) {

                        users.clear()

                        val jsonArray = response?.optJSONArray("result")


                        if(jsonArray?.length() == 0){
                            loading.dismiss()
                        }
//
                        for(i in 0 until jsonArray?.length()!!){

                            val jsonObject = jsonArray?.optJSONObject(i)
                            var pathImg: String = ""
                            if(jsonObject.getString("image") == ""){
                                pathImg="https://fahrulakbar.000webhostapp.com/homespital/admin/Homespital/assets/post/article/noimage.jpg"
                            }else {
                                pathImg = "https://fahrulakbar.000webhostapp.com/homespital/admin/Homespital/assets/post/article/" + jsonObject.getString("image")
                            }
                            var tes=Html.fromHtml(jsonObject.getString("content"))
                                users.add(Artikel(jsonObject.getString("title"),
                                    tes.toString(),
                                    jsonObject.getString("nama_kategori"),pathImg))

                                    if(jsonArray?.length() - 1 == i){

                                loading.dismiss()
                                val adapter = ArtikelHorizontalAdapter(context!!, users)
                                adapter.notifyDataSetChanged()
                                recyclerView.adapter = adapter

                            }


                        }
                    }

                })

    }

}