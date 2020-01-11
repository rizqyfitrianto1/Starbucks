package com.example.tugasbesarkotlin3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Splash : AppCompatActivity() {

    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        imageView = findViewById<View>(R.id.logostar) as ImageView?
        val myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        imageView!!.startAnimation(myanim)

        val intent = Intent(this, SignIn::class.java)

        val timer = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                }
            }
        }
        timer.start()
    }
}
