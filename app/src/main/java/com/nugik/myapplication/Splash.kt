package com.nugik.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Splash : AppCompatActivity() {

//    private var mDelayHandler: Handler? = null
//    private val SPLASH_DELAY: Long = 3000
//
//    internal val mRunnable: Runnable = Runnable {
//        if (!isFinishing) {
//
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
