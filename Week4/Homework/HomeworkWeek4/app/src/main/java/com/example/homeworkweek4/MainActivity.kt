package com.example.homeworkweek4

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter


class MainActivity : AppCompatActivity() {
    private val fileName = "test01.txt"
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)

        val buttonFinish: Button = findViewById(R.id.saveButton)

        buttonFinish.setOnClickListener {
            if(ContextCompat.checkSelfPermission(
                    applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(this, permissions, 11111)
            } else {
                finish()
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            11111 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    finish()
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    fun readFile() {
        try {
            val path = "mnt/sdcard/$fileName"
            val file = File(path)
            val inputStream: InputStream = FileInputStream(file)
            val inputStreamReader = InputStreamReader(inputStream)
            val reader = BufferedReader(inputStreamReader)
            val stringBuffer = StringBuffer()

            var line: String? = reader.readLine()
            while (line != null) {
                stringBuffer.append(line + "\n")
                line = reader.readLine()
            }

            inputStream.close()
            reader.close()
            editText.setText(stringBuffer.toString())
        } catch (_: FileNotFoundException) {
        } catch (t: Throwable) {
            Toast.makeText(this, "Exception: $t", Toast.LENGTH_SHORT).show()
        }
    }

    fun createAndWriteFile() {
        try {
            val path = "mnt/sdcard/$fileName"
            val file = File(path)
            file.createNewFile()
            val outputStream = FileOutputStream(file)
            val writer = OutputStreamWriter(outputStream)

            writer.write(editText.text.toString())
            writer.close()
            outputStream.close()
        } catch (t: Throwable) {
            editText.setText(t.message)
        }
    }
}