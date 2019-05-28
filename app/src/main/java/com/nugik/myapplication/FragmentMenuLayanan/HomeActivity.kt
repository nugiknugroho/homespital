package com.nugik.myapplication.FragmentMenuLayanan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                val fragment = FragmentHome()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_fav -> {
                val fragment = FragmentArticle()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_history -> {
                val fragment = FragmentHistory()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notif -> {
                val fragment = FragmentNotif()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profil -> {
                val fragment = FragmentAccount()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_snackbar_in, R.anim.design_snackbar_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = FragmentHome()
        addFragment(fragment)
    }

}
