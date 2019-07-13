package com.nugik.myapplication.API

class ApiEndPoint {

    companion object {

        private val SERVER = "https://fahrulakbar.000webhostapp.com/homespital/ws/"
        val CREATE = SERVER +"register.php"
        val DELETE = SERVER +"delete.php"
        val UPDATE = SERVER +"update.php"
        val READ_LOGIN = SERVER +"read_login.php"
        val READ = SERVER +"read.php"
        val READ_BIDAN = SERVER +"read_bidan.php"
        val READ_PERAWAT = SERVER +"read_perawat.php"
        val READ_ARTIKEL = SERVER +"read_artikel.php"
        val READ_AMBULANCE = SERVER +"read_ambulance.php"
        val BOOKING = SERVER +"booking.php"
        val HISTORY = SERVER +"history.php"
        val PESAN = SERVER+"pesan.php"
        val TAMPIL_PESAN= SERVER+"tampil_pesan.php"
        val TAMPIL_DETAIL= SERVER+"detail_history.php"
        val HISTORY_pesan= SERVER+"history_pesan.php"
    }

}