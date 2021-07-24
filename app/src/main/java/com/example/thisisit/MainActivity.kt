package com.example.thisisit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: LoginViewModel
    lateinit var context: Context
    lateinit var userName: EditText
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val btnAddLogin: Button = findViewById(R.id.btnAddLogin)
        val btnread: Button = findViewById(R.id.btnReadLogin)
        userName = findViewById<EditText>(R.id.txtUsername)

        btnAddLogin.setOnClickListener {
            setUser()
        }
        btnread.setOnClickListener { findUser() }
    }

    private fun findUser() {
        val user: String = userName.text.trim().toString()

        if (!user.isEmpty()) {
            LoginRepository.getUserDetails(context, user)!!.observe(this,
                Observer {
                    if (it == null) {
                        //data not found error
                    } else {
                        var fetchedUserName: String = it.username
                        var fetchedPassword: String = it.password
                        //use this to prefill
                    }
                })
        }
    }

    private fun setUser() {
        val user: String = userName.text.trim().toString()

        password = findViewById<EditText>(R.id.txtPassword).text.trim().toString()
        if (user.isEmpty()) {
            //set user error text
        } else if (password.isEmpty()) {
            //set password error text
        } else {
            LoginRepository.insertData(context, user, password)
//                                show: "Inserted Successfully"
        }
    }
}