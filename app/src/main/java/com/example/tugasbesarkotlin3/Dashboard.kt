package com.example.tugasbesarkotlin3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import android.widget.ImageView
import android.widget.ViewFlipper
import com.example.tugasbesarkotlin3.Paging.MenuListActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    internal lateinit var v_flipper: ViewFlipper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val animation2 = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        img_menu.startAnimation(animation2)
        img_map.startAnimation(animation2)

        img_map.setOnClickListener {
            startActivity(Intent(this, Location::class.java))
        }

        img_menu.setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }

        val images = intArrayOf(R.drawable.promo1, R.drawable.promo2, R.drawable.promo3)
        v_flipper = findViewById<ViewFlipper>(R.id.v_flipper)

        for (image in images) {
            flipperImages(image)
        }
    }

    fun flipperImages(image: Int) {
        val imageView = ImageView(this)
        imageView.setImageResource(image)

        v_flipper.addView(imageView)
        v_flipper.setFlipInterval(2000)
        v_flipper.isAutoStart = true

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left)
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right)

    }
}
