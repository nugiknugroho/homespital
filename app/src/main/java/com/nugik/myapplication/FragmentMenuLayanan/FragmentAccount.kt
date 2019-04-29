package com.nugik.myapplication.FragmentMenuLayanan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.LogRegister.SessionManager
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.fragment_account.*

class FragmentAccount :Fragment(){

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

        edt_nama_lengkap.setText(name)
        edt_email.setText("Email" +email)

        btn_logout?.setOnClickListener {
            session.logoutUser()
        }

    }
}
