package com.nugik.myapplication.DetailActivityMenu.Klinik

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nugik.myapplication.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_klinik_maps.*

class KlinikMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var i: Intent
    private var googleMap:GoogleMap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klinik_maps)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        i = intent

        if(i.hasExtra(  "pesan")){

            if(i.getStringExtra("pesan").equals("1")){

                onEditMode()

            }

        }

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun onEditMode(){

        tv_detail_nama_klinik.setText(i.getStringExtra("nm_klinik"))
        tv_detail_alamatklinik.setText(i.getStringExtra("alamat_klinik"))
        tv_detail_telpklinik.setText(i.getStringExtra("no_telp"))
    }

    override fun onMapReady(p0: GoogleMap?) {
        googleMap=p0

        val latLng=LatLng(-7.965477,112.637884)
        val markerOptions:MarkerOptions=MarkerOptions().position(latLng).title("Rumah Sakit Lavalette")
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))

        //
        val latLng1=LatLng(-7.9580862,112.6111963)
        val markerOptions1:MarkerOptions=MarkerOptions().position(latLng1).title("UMM Medical Centre")
        markerOptions1.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng2=LatLng(-8.0241947,112.6309853)
        val markerOptions2:MarkerOptions=MarkerOptions().position(latLng2).title("Klinik Bumi Ayu")
        markerOptions2.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng3=LatLng(-7.9711574,112.5965173)
        val markerOptions3:MarkerOptions=MarkerOptions().position(latLng3).title("Klinik Bunga Melati")
        markerOptions3.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng4=LatLng(-7.9798913,112.6561204)
        val markerOptions4:MarkerOptions=MarkerOptions().position(latLng4).title("Klinik Elisa")
        markerOptions4.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng5=LatLng(-7.9383971,112.6297736)
        val markerOptions5:MarkerOptions=MarkerOptions().position(latLng5).title("Poliklinik Widya Husada")
        markerOptions5.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng6=LatLng(-7.9416121,112.6387419)
        val markerOptions6:MarkerOptions=MarkerOptions().position(latLng6).title("Klinik Sabilillah Medical Service")
        markerOptions6.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng7=LatLng(-7.9416014,112.6387419)
        val markerOptions7:MarkerOptions=MarkerOptions().position(latLng7).title("KLINIK PANTI RAHAYU")
        markerOptions7.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions7.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng8=LatLng(-7.9795333,112.6607139)
        val markerOptions8:MarkerOptions=MarkerOptions().position(latLng8).title("Klinik Telemedika Health Centre")
        markerOptions8.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions8.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng9=LatLng(-7.95988,112.6407457)
        val markerOptions9:MarkerOptions=MarkerOptions().position(latLng9).title("Klinik Sanan Medika")
        markerOptions9.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions9.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng10=LatLng(-7.9570617,112.6036363)
        val markerOptions10:MarkerOptions=MarkerOptions().position(latLng10).title("Klinik Daqu Sehat")
        markerOptions10.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions10.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng11=LatLng(-7.9626028,112.6074986)
        val markerOptions11:MarkerOptions=MarkerOptions().position(latLng11).title("Poliklinik UM")
        markerOptions11.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions11.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng12=LatLng(-7.9725828,112.6166375)
        val markerOptions12:MarkerOptions=MarkerOptions().position(latLng12).title("Klinik ABAL-ABAL")
        markerOptions12.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions12.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng13=LatLng(-7.9508721,112.6070266)
        val markerOptions13:MarkerOptions=MarkerOptions().position(latLng13).title("Klinik Hasifa")
        markerOptions13.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions13.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        //
        val latLng14=LatLng(-7.9682979,112.6149659)
        val markerOptions14:MarkerOptions=MarkerOptions().position(latLng14).title("Klinik Yayasan Padmajaya")
        markerOptions14.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))
        markerOptions14.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))

        //
        val latLng21=LatLng(-7.971842,112.6158437)
        val markerOptions21:MarkerOptions=MarkerOptions().position(latLng21).title("Lokasi Saya")
        markerOptions21.icon(BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.mipmap.ic_user_location)))

        // moving camera and zoom map
        val zoomLevel = 14.0f //This goes up to 21

        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))

            it!!.addMarker(markerOptions1)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng1, zoomLevel))

            it!!.addMarker(markerOptions2)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, zoomLevel))

            it!!.addMarker(markerOptions3)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng3, zoomLevel))

            it!!.addMarker(markerOptions4)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng4, zoomLevel))

            it!!.addMarker(markerOptions5)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng5, zoomLevel))

            it!!.addMarker(markerOptions6)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng6, zoomLevel))

            it!!.addMarker(markerOptions7)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng7, zoomLevel))

            it!!.addMarker(markerOptions8)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng8, zoomLevel))

            it!!.addMarker(markerOptions9)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng9, zoomLevel))

            it!!.addMarker(markerOptions10)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng10, zoomLevel))

            it!!.addMarker(markerOptions11)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng11, zoomLevel))

            it!!.addMarker(markerOptions12)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng12, zoomLevel))

            it!!.addMarker(markerOptions13)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng13, zoomLevel))

            it!!.addMarker(markerOptions14)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng14, zoomLevel))

            it!!.addMarker(markerOptions21)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng21, zoomLevel))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            (android.R.id.home)->{
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
