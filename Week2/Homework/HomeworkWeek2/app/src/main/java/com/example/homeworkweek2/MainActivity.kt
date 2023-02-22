package com.example.homeworkweek2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

class MainActivity : AppCompatActivity() {
    private var viButton: Button? = null
    private var enButton: Button? = null

    object LocaleUtils {
        fun setLocale(context: Context, language: String) {
            // Tạo một đối tượng Locale từ mã ngôn ngữ được chỉ định
            val locale = Locale(language)
            // Đặt locale mặc định là đối tượng Locale vừa tạo
            Locale.setDefault(locale)
            // Lấy tài nguyên của ứng dụng
            val resources: Resources = context.resources
            // Lấy cấu hình của ứng dụng
            val config: Configuration = resources.configuration
            // Thiết lập locale của cấu hình thành đối tượng Locale vừa tạo
            config.setLocale(locale)
            // Cập nhật cấu hình tài nguyên của ứng dụng với cấu hình đã cập nhật
            // và các thông số hiển thị của thiết bị
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viButton = findViewById(R.id.vietnameseButton)
        enButton = findViewById(R.id.englishButton)

        viButton?.setOnClickListener {
            LocaleUtils.setLocale(this, "vi")
            recreate()
        }

        enButton?.setOnClickListener {
            LocaleUtils.setLocale(this, "en")
            recreate()
        }
    }
}