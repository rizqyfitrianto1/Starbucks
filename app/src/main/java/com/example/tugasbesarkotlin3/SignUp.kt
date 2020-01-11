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
import com.example.tugasbesarkotlin3.Models.User
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.linearLay

class SignUp : AppCompatActivity() {

    lateinit var animationDrawable: AnimationDrawable

    private var add_firstname: EditText? = null
    private var add_lastname: EditText? = null
    private var add_email: EditText? = null
    private var add_password: EditText? = null

    private var btn_signUp: Button? = null

    private var userDao: UserDao? = null

    private var progressDialog: ProgressDialog? = null

    private val isEmpty: Boolean
        get() = if (TextUtils.isEmpty(add_email!!.text.toString()) ||
            TextUtils.isEmpty(add_password!!.text.toString()) ||
            TextUtils.isEmpty(add_firstname!!.text.toString()) ||
            TextUtils.isEmpty(add_lastname!!.text.toString())
        ) {
            true
        } else {
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        animationDrawable = linearLay.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()

        backMasuk.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }

        progressDialog = ProgressDialog(this)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Registering...")
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.isIndeterminate
        progressDialog!!.setIndeterminateDrawable(resources.getDrawable(R.drawable.progress_icon))
        progressDialog!!.progress = 0


        add_firstname = findViewById(R.id.add_firstname)
        add_lastname = findViewById(R.id.add_lastname)
        add_email = findViewById(R.id.add_email)
        add_password = findViewById(R.id.add_pasword)

        btn_signUp = findViewById(R.id.btn_signUp)

        userDao = Room.databaseBuilder(this, UserDatabase::class.java!!, "mi-database.db")
            .allowMainThreadQueries()
            .build()
            .userDao

        btn_signUp!!.setOnClickListener {
            if (!isEmpty) {

                progressDialog!!.show()

                Handler().postDelayed({
                    val user = User(
                        add_firstname!!.text.toString(), add_lastname!!.text.toString(),
                        add_email!!.text.toString(), add_password!!.text.toString()
                    )
                    userDao!!.insert(user)
                    progressDialog!!.dismiss()
                    startActivity(Intent(this@SignUp, Dashboard::class.java))
                }, 1000)

            } else {
                Toast.makeText(this@SignUp, "Empty Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
