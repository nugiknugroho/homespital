package com.ekapuji.bukutamumaster2

import android.content.Context
import android.content.SharedPreferences

class PrefManager(internal var _context: Context) {
    internal var pref: SharedPreferences
    internal var editor: SharedPreferences.Editor

    // shared pref mode
    internal var PRIVATE_MODE = 0

    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun setPrefSring(variable: String, value: String?) {
        editor.putString(variable, value)
        editor.commit()
    }

    fun getPrefSring(variable: String): String? {
        return pref.getString(variable, null)
    }

    fun getPrefSring(variable: String, value: String): String? {
        return pref.getString(variable, value)
    }

    fun getPrefBoolean(variable: String): Boolean? {
        return pref.getBoolean(variable, true)
    }

    fun setPrefBoolean(variable: String, mute: Boolean?) {
        editor.putBoolean(variable, mute!!)
        editor.commit()
    }

    companion object {

        // Shared preferences file name
        private val PREF_NAME = "androidhive-welcome"
        private val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    }

}
