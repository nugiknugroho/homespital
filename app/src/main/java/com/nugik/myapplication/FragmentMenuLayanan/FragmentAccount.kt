package com.nugik.myapplication.FragmentMenuLayanan

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.LogRegister.SessionManager
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_account.*
import org.json.JSONObject

class FragmentAccount :Fragment(){
    lateinit var i: Intent
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        session = SessionManager(this!!.context!!)
        session.checkLogin()

        var user: HashMap<String, String> = session.getUserDetails()

        var name: String = user.get(SessionManager.KEY_NAME)!!
        var email: String = user.get(SessionManager.KEY_EMAIL)!!

        tv_namaLengkap.setText(name)

        btn_logout?.setOnClickListener {
            session.logoutUser()
        }

    }

}
