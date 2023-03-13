package com.example.homeworkweek5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var adapter: MyGridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grid = findViewById<GridView>(R.id.gridView)
        val companyList = generateCompanyData()
        adapter = MyGridAdapter(this, companyList)
        grid.adapter = adapter

        grid.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Selected company is: " + companyList[i].name,
            Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateCompanyData(): ArrayList<Company> {
        val result = ArrayList<Company>()

        var company: Company = Company()
        company.id = 1
        company.name = "apple"
        company.networth = "USD 1000k$"
        company.logo = R.drawable.c1
        result.add(company)

        company = Company()
        company.id = 6
        company.name = "Nikon"
        company.networth = "USD 1000k$"
        company.logo = R.drawable.c6
        result.add(company)

        return result
    }
}