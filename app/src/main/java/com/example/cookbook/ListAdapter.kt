package com.example.cookbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(private val context: Context, private val items: List<String>) :
    ArrayAdapter<String>(context, R.layout.list_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val itemName = view.findViewById<TextView>(R.id.name_recipe)

        itemName.text = items[position]


        return view
    }
}
