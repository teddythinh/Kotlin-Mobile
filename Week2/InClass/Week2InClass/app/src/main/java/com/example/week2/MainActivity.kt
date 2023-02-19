package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var USDtoVND: Double = 22.7
    var CADtoVND: Double = 17.6

    var etUSD: EditText? = null
    var etCAD: EditText? = null
    var etVND: EditText? = null

    var btnConvert: Button? = null
    var btnClear: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUSD = findViewById(R.id.editTextUSD)
        etCAD = findViewById(R.id.editTextCAD)
        etVND = findViewById(R.id.editTextVND)
        btnConvert = findViewById(R.id.buttonConvert)
        btnClear = findViewById(R.id.buttonClear)

        btnClear?.setOnClickListener {
            etUSD?.setText("")
            etCAD?.setText("")
            etVND?.setText("")
        }

        btnConvert?.setOnClickListener {
            val USDval = etUSD?.text.toString().toDouble()/USDtoVND
            val CADval = etCAD?.text.toString().toDouble()/CADtoVND

            val formatter = DecimalFormat("###,###,###,##")
            etUSD?.setText(formatter.format(USDval))
            etCAD?.setText(formatter.format(CADval))
        }

    }
}