package com.nugik.myapplication.FragmentMenuLayanan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.internal.BottomNavigationItemView
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import android.annotation.SuppressLint
import android.util.Log
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private var content: FrameLayout? = null
    val TAG = "MyMessage"

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

    @SuppressLint("RestrictedApi")
    fun BottomNavigationView.disableShiftMode() {
        val menuView = getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView::class.java.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                // set once again checked value, so view will be updated
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "Unable to get shift mode field", e)
        } catch (e: IllegalStateException) {
            Log.e(TAG, "Unable to change value of shift mode", e)
        }
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
        navigation.disableShiftMode()
        val fragment = FragmentHome()
        addFragment(fragment)
    }

}
