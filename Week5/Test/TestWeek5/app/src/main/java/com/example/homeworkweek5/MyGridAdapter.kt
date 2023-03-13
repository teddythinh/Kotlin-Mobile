package com.example.homeworkweek5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class Company {
    var id: Int? = 0
    var name: String? = null
    var networth: String? = null
    var logo: Int? = null
}

// Context class that is used to inflate views and access system services.
// ArrayList of Company objects that contains the data to be displayed in the grid.
// ViewHolder: A nested class that holds references to the views used to display each item in the grid.
class MyGridAdapter (private var context: Context, private var items: ArrayList<Company>): BaseAdapter() {

    // Define a nested ViewHolder class that holds references to the views used to display each item in the grid
    private class ViewHolder(row: View?) {
        var nameTV: TextView? = null
        var networthTV: TextView? = null
        var logoIV: ImageView? = null

        init {
            nameTV = row?.findViewById<TextView>(R.id.nameTV)
            networthTV = row?.findViewById<TextView>(R.id.networkTV)
            logoIV = row?.findViewById<ImageView>(R.id.logoIV)
        }
    }

    // This method is called by the grid view to get a view for each item in the grid
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        // If the convertView parameter is null, inflate a new view from the hd_list_item layout file
        // and create a new ViewHolder object to hold references to the views
        if(convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            view = (inflater as LayoutInflater).inflate(R.layout.hd_list_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }
        // If convertView is not null, reuse the existing view and retrieve its ViewHolder object from the tag
        else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val company = items[position]
        viewHolder.nameTV?.text = company.name
        viewHolder.networthTV?.text = company.networth
        viewHolder.logoIV?.setImageResource(company.logo!!)

        return view as View
    }

    override fun getItem(i: Int): Company {
        return items[i]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}