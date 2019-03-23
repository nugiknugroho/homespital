package com.nugik.myapplication.API

class ApiEndPoint {

    companion object {

        private val SERVER = "http://fahrulakbar.000webhostapp.com/homepital/"
        val CREATE = SERVER +"register.php"
        val READ = SERVER +"read.php"
        val DELETE = SERVER +"delete.php"
        val UPDATE = SERVER +"update.php"
        val READ_LOGIN = SERVER +"read_login.php"

    }

}