package com.nugik.myapplication.LogRegister

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SessionManager{

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con: Context
    var PRIVATE_MODE: Int = 0

    constructor(context: Context){
//        this.con = con
        pref = PreferenceManager.getDefaultSharedPreferences(context)
        editor = pref.edit()
    }

    companion object {
        val PREF_NAME: String = "Coba"
        val IS_LOGIN: String = "isLogin"
        val KEY_NAME: String = "name"
        val KEY_EMAIL: String = "email"
        val KEY_ID: String="id";
        val PW: String="pw";

    }

    fun createLoginSession(name: String, email: String, id: String,pw: String){

        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_ID, id)
        editor.putString(PW, pw)
        editor.commit()
    }

    fun checkLogin(){
        if (!this.isLoggedIn()){
            var i:Intent = Intent(con, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }
    }

    fun getUserDetails():HashMap<String, String>
    {
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_ID, pref.getString(KEY_ID,null))
        (user as HashMap).put(KEY_NAME, pref.getString(KEY_NAME, null))
        (user as HashMap).put(KEY_EMAIL, pref.getString(KEY_EMAIL, null))
        (user as HashMap).put(PW, pref.getString(PW, null))
        return  user
    }

    fun logoutUser(){
        editor.clear()
        editor.commit()

        var i:Intent = Intent(con, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        con.startActivity(i)
    }

    fun isLoggedIn(): Boolean{
        return pref.getBoolean(IS_LOGIN, false)
    }

}