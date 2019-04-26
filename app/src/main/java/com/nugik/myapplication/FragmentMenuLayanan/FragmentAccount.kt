package com.nugik.myapplication.FragmentMenuLayanan

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nugik.myapplication.LogRegister.MainActivity
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
        var date: String? = user!!.get(SessionManager.KEY_DATE)
        var gender: String? = user!!.get(SessionManager.KEY_GENDER)
        var email: String? = user!!.get(SessionManager.KEY_EMAIL)
        var username: String? = user!!.get(SessionManager.KEY_USERNAME)
        var password: String? = user!!.get(SessionManager.KEY_PASSWORD)
        var kotaasal: String? = user!!.get(SessionManager.KEY_KOTAASAL)
        var alamat: String? = user!!.get(SessionManager.KEY_ALAMAT)

        tv_namaLengkap.setText(name)
        tv_tglLahir.setText(date)
        tv_gender.setText(gender)
        tv_email.setText(email)
        tv_username.setText(username)
        tv_password.setText(password)
        tv_kotaAsal.setText(kotaasal)
        tv_alamatLengkap.setText(alamat)

        btn_logout?.setOnClickListener {
            session.logoutUser()
        }

    }
}
