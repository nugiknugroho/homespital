package com.nugik.myapplication.DetailActivityMenu.Bidan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_bidan.*


class Sessionbidan {
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
        val KEY_ID: String="id";
        val PW: String="pw";

    }

    fun Sessionbidan(id: String){

        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_ID, id)
        editor.commit()
    }

    fun getBidanDetails():HashMap<String, String>
    {
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_ID, pref.getString(KEY_ID,null))
        return  user
    }


}