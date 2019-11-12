package com.nugik.myapplication.FragmentMenuLayanan

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
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

class FragmentAccount :Fragment() {
    lateinit var i: Intent
    lateinit var session: SessionManager

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(context,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(context,
                android.R.string.no, Toast.LENGTH_SHORT).show()
    }

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
        var tanggal: String = user.get(SessionManager.TGL)!!
        var jk :String =user.get(SessionManager.JK)!!
        var email:String=user.get(SessionManager.KEY_EMAIL)!!
        var username:String=user.get(SessionManager.KEY_NAME)!!
        var kota:String=user.get(SessionManager.KOTA)!!
        var alamat:String=user.get(SessionManager.AL)!!

        tv_namaLengkap.setText(name)
//        tv_tglLahir.setText(tanggal)
        tv_email.setText(email)
        tv_username.setText(username)
        tv_kotaAsal.setText(kota)
        tv_alamatLengkap.setText(alamat)

//        tv_gender.setText(jk)
        btn_logout?.setOnClickListener {
            session.logoutUser()
        }

        tv_edit_profil.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)

            with(builder)
            {
                setTitle("Sunting Profil")
                setMessage("Anda yakin mengubah ini ?")
                setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                setNegativeButton(android.R.string.no, negativeButtonClick)
                show()
            }
        }

    }

}