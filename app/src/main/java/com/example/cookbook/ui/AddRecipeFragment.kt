package com.example.cookbook.ui

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cookbook.R
import kotlin.math.log

class AddRecipeFragment : Fragment() {

    lateinit var nameRecipe: EditText
    lateinit var ingredientsRecipe: EditText
    lateinit var instructionsRecipe: EditText
    lateinit var ratingBar: RatingBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        nameRecipe = view.findViewById(R.id.recipe_name)
        ingredientsRecipe = view.findViewById(R.id.recipe_ingredients)
        instructionsRecipe = view.findViewById(R.id.recipe_instructions)
        ratingBar = view.findViewById(R.id.recipe_ratingbar)



        val sharedPreferences = requireContext().getSharedPreferences("mojeDane", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

//        nameRecipe.setText(sharedPreferences.getString("name", ""))
//        ingredientsRecipe.setText(sharedPreferences.getString("ingredients", ""))
//        instructionsRecipe.setText(sharedPreferences.getString("instructions", ""))
//        ratingBar.rating = sharedPreferences.getFloat("rating", 0f)



        val btn: Button = view.findViewById(R.id.recipe_save)
        btn.setOnClickListener {
//            editor.putString("name", nameRecipe.text.toString())
//            editor.putString("ingredients", ingredientsRecipe.text.toString())
//            editor.putString("instructions", instructionsRecipe.text.toString())
//            editor.putFloat("rating", ratingBar.rating)
//            editor.apply()
            val recipeName = nameRecipe.text.toString()
            val recipeIngredients = ingredientsRecipe.text.toString()
            val recipeInstructions = instructionsRecipe.text.toString()
            val recipeRating = ratingBar.rating.toString()

            if(recipeName.isNotBlank() && recipeIngredients.isNotBlank() && recipeInstructions.isNotBlank() && recipeRating.isNotBlank()){
                val recipeData = "$recipeName|$recipeIngredients|$recipeInstructions|$recipeRating"

                val existingRecipes = sharedPreferences.getString("recipes", "")

                val updatedRecipes = if (existingRecipes.isNullOrEmpty()){
                    recipeData
                } else {
                    "$existingRecipes;$recipeData"
                }

                editor.putString("recipes", updatedRecipes).apply()
                Toast.makeText(requireContext(), "Przepis dodany", Toast.LENGTH_SHORT).show()

                nameRecipe.text.clear()
                ingredientsRecipe.text.clear()
                instructionsRecipe.text.clear()
                ratingBar.rating = 2.5f
            } else{
                Toast.makeText(requireContext(), "Wszystkie pola muszą być wypełnione", Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object {
    }
}