package com.example.homeworkweek4_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    var fullname: EditText? = null
    var birthday: EditText? = null
    var classroom: EditText? = null
    var gender: RadioGroup? = null
    var male: RadioButton? = null
    var female: RadioButton? = null
    var other: RadioButton? = null
    private var saveButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fullname = findViewById(R.id.fullnameTextView)
        birthday = findViewById(R.id.dobTextView)
        classroom = findViewById(R.id.classroom)
        gender = findViewById(R.id.radioGroup2)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        other = findViewById(R.id.otherGender)
        saveButton = findViewById(R.id.saveButton1)

        saveButton?.setOnClickListener {
            val i = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(i)
        }
    }
}