package com.example.homeworkweek4_2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter (
    private val context: Activity, private val fullname: List<String>,
    private val classroom: List<String>, private val birthday: List<String>,
    private val gender: List<String>, private val icons: List<Int>
    ): ArrayAdapter<String>(context, R.layout.list_item_1, fullname)
    {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val rowView: View = inflater.inflate(R.layout.list_item_1, null, true)
            val fullnameText = rowView.findViewById(R.id.nameTV) as TextView
            val classroomText = rowView.findViewById(R.id.classroomTV) as TextView
            val birthdayText = rowView.findViewById(R.id.birthdayTV) as TextView
            val genderText = rowView.findViewById(R.id.genderTV) as TextView
            val imageView: ImageView = rowView.findViewById(R.id.iconIV) as ImageView

            fullnameText.text = fullname[position]
            classroomText.text = classroom[position]
            birthdayText.text = birthday[position]
            genderText.text = gender[position]
            imageView.setImageResource(icons[position])

            return rowView
        }
    }