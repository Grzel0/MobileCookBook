package com.example.cookbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.cookbook.ui.RecipeDetailsFragment

class ListAdapter(private val context: Context, private val items: List<String>) :
    ArrayAdapter<String>(context, R.layout.list_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val itemName = view.findViewById<TextView>(R.id.name_recipe)
        val detailButton = view.findViewById<Button>(R.id.detail_recipe)

        val recipe = items[position]
        val parts = recipe.split("|")

        if(parts.isNotEmpty()){
            itemName.text = parts[0]
        }
        detailButton.setOnClickListener {
            if (parts.size == 4) {
                val recipeName = parts[0]
                val recipeIngredients = parts[1]
                val recipeInstrucions = parts[2]
                val recipeRating = parts[3].toFloatOrNull() ?: 0f

                val fragment = RecipeDetailsFragment.newInstance(recipeName, recipeIngredients, recipeInstrucions, recipeRating)

                if(context is FragmentActivity){
                    context.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
        return view
    }
}
