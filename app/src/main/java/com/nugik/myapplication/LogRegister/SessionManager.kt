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
        val KEY_DATE: String = "date"
        val KEY_GENDER: String = "gender"
        val KEY_EMAIL: String = "email"
        val KEY_USERNAME: String = "username"
        val KEY_PASSWORD: String = "password"
        val KEY_KOTAASAL: String = "kotaasal"
        val KEY_ALAMAT: String = "alamat"

    }

    fun createLoginSession(name: String, date: String, gender: String,
                           email: String,
                           username: String, password: String, kotaasal: String,
                           alamat: String){
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, date)
        editor.putString(KEY_GENDER, gender)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_USERNAME, username)
        editor.putString(KEY_PASSWORD, password)
        editor.putString(KEY_KOTAASAL, kotaasal)
        editor.putString(KEY_ALAMAT, alamat)
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
        (user as HashMap).put(KEY_NAME, pref.getString(KEY_NAME, null))
        (user as HashMap).put(KEY_DATE, pref.getString(KEY_DATE, null))
        (user as HashMap).put(KEY_NAME, pref.getString(KEY_GENDER, null))
        (user as HashMap).put(KEY_EMAIL, pref.getString(KEY_EMAIL, null))
        (user as HashMap).put(KEY_USERNAME, pref.getString(KEY_USERNAME, null))
        (user as HashMap).put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null))
        (user as HashMap).put(KEY_KOTAASAL, pref.getString(KEY_KOTAASAL, null))
        (user as HashMap).put(KEY_ALAMAT, pref.getString(KEY_ALAMAT, null))
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