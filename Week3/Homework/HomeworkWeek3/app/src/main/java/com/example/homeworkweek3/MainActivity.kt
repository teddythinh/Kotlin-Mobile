package com.example.homeworkweek3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
//import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var loginButton: Button? = null
//    private val text = "Login successfully"
//    private val duration = Toast.LENGTH_SHORT
//    private val toast = Toast.makeText(applicationContext, text, duration)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.userNameInput)
        password = findViewById(R.id.passwordInput)
        loginButton = findViewById(R.id.button)

//        loginButton?.setOnClickListener {
//            toast.show()
//        }

    }
}