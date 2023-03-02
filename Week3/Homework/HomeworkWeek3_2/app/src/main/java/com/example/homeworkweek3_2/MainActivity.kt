package com.example.homeworkweek3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val text = "Hello toast!"
    val duration = Toast.LENGTH_SHORT

    var button: Button? = null

    // val toast = Toast.makeText(applicationContext, text, duration)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button3)

//        button?.setOnClickListener {
//            toast.show()
//        }
    }
}