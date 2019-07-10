package com.nugik.myapplication.Data

class Dokter{
    var name: String? = null
    var spesialis: String? = null
    var harga: String? = null
    var status: String? = null
    var id:String? = null

    constructor(name: String, spesialis: String, harga: String, status: String, id: String){

        this.name =  name
        this.spesialis = spesialis
        this.harga = harga
        this.status = status
        this.id = id
    }



}
