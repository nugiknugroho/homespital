package com.nugik.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val monNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.nav_home -> {
                createFragmentOne()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_fav -> {
                createFragmentTwo()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_history -> {
                createFragmentThree()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notif -> {
                createFragmentFour()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profil -> {
                createFragmentFive()
                return@OnNavigationItemSelectedListener true
            }

        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        createFragmentOne()
        bottom_nav.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener)
    }

    fun createFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentHome()
        transaction.replace(R.id.fragmnet_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentArticle()
        transaction.replace(R.id.fragmnet_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun createFragmentThree(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentHistory()
        transaction.replace(R.id.fragmnet_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun createFragmentFour(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentNotif()
        transaction.replace(R.id.fragmnet_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentFive(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentAccount()
        transaction.replace(R.id.fragmnet_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
