package com.example.cookbook.ui

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.cookbook.ListAdapter
import com.example.cookbook.R


class RecipeListFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var btn: Button
    private var recipeNames = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.recipe_list_view)
        btn = view.findViewById(R.id.add_recipe_button)

        val sharedPreferences = requireContext().getSharedPreferences("mojeDane", MODE_PRIVATE)
        val recipes = sharedPreferences.getString("recipes", "")

        recipeNames.clear()
        if (!recipes.isNullOrEmpty()){
            val recipeArray = recipes.split(";")
            recipeArray.forEach{recipe ->
                val recipeData = recipe.split("|")
                if(recipeData.isNotEmpty()){
                    recipeNames.add(recipe)
                }
            }
        }

        listView.adapter = ListAdapter(requireContext(), recipeNames)

        btn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AddRecipeFragment())
                .addToBackStack(null)
                .commit()
        }
    }






    companion object {

    }
}