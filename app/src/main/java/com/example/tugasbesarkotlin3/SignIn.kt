package com.example.tugasbesarkotlin3

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.tugasbesarkotlin2.Database.UserDao
import com.example.tugasbesarkotlin2.Database.UserDatabase
import kotlinx.android.synthetic.main.activity_signin.*

class SignIn : AppCompatActivity() {

    lateinit var animationDrawable: AnimationDrawable

    private var add_email: EditText? = null
    private var add_password: EditText? = null
    private var btn_signIn: Button? = null

    private var userDao: UserDao? = null
    private var database: UserDatabase? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        animationDrawable = linearLay.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()

        goDaftar.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        progressDialog = ProgressDialog(this)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Check User...")
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.isIndeterminate
        progressDialog!!.setIndeterminateDrawable(resources.getDrawable(R.drawable.progress_icon))
        progressDialog!!.progress = 0


        database = Room.databaseBuilder(this, UserDatabase::class.java!!, "mi-database.db")
            .allowMainThreadQueries()
            .build()

        userDao = database!!.userDao


        btn_signIn = findViewById(R.id.btn_signIn)
        add_email = findViewById(R.id.add_email)
        add_password = findViewById(R.id.add_pasword)

        btn_signIn!!.setOnClickListener {
            if (!emptyValidation()) {
                progressDialog!!.show()
                Handler().postDelayed({
                    val user = userDao!!.getUser(add_email!!.text.toString(), add_password!!.text.toString())
                    if (user != null) {
                        val i = Intent(this@SignIn, Dashboard::class.java)
                        i.putExtra("User", user)
                        startActivity(i)
                        finish()
                    } else {
                        Toast.makeText(this@SignIn, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show()
                    }
                    progressDialog!!.dismiss()
                }, 1000)

            } else {
                Toast.makeText(this@SignIn, "Empty Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun emptyValidation(): Boolean {
        return if (TextUtils.isEmpty(add_email!!.text.toString()) || TextUtils.isEmpty(add_password!!.text.toString())) {
            true
        } else {
            false
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
