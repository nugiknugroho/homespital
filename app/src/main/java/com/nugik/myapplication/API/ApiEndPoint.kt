package com.nugik.myapplication.API

class ApiEndPoint {

    companion object {

        private val SERVER = "http://alfathtech.co.id/homespital/ws/"
        val CREATE = SERVER +"register.php"
        val DELETE = SERVER +"delete.php"
        val UPDATE = SERVER +"update.php"
        val READ_LOGIN = SERVER +"read_login.php"
        val READ = SERVER +"read.php"
        val READ_BIDAN = SERVER +"read_bidan.php"
        val READ_PERAWAT = SERVER +"read_perawat.php"
        val READ_ARTIKEL = SERVER +"read_artikel.php"

    }

}