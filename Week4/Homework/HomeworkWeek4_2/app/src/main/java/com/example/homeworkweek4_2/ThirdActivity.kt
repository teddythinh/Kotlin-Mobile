package com.example.homeworkweek4_2

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class ThirdActivity : AppCompatActivity() {

    private var selectedTV: TextView? = null
    private var customListView: ListView? = null

    private var fullname = arrayListOf<String>()
    private var classroom = arrayListOf<String>()
    private var birthday = arrayListOf<String>()
    private var gender = arrayListOf<String>()
    private var icons = arrayListOf<Int>()

    private fun createData() {
        fullname = arrayListOf("Thinh", "Phuc", "Nguyen", "Tu")
        classroom = arrayListOf("20KTPM01", "20KTPM02", "20KTPM03")
        birthday = arrayListOf("01/10/2002", "02/05/2001", "05/12/2000", "05/11/1999")
        gender = arrayListOf("Male", "Male", "Male", "Male")
        icons = arrayListOf(R.drawable.presentation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        customListView = findViewById(R.id.studentListView)
        selectedTV = findViewById(R.id.titleScreen3)

        createData()

        val adapter = MyListAdapter(this, fullname, classroom, birthday, gender, icons)
        customListView!!.adapter = adapter

        customListView!!.setOnItemClickListener { adapterView, view, i, l ->
            val text = "Position: " + i.toString() + "\nTitle: " + fullname[i]
            selectedTV!!.text = text
        }
    }
}