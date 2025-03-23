package com.example.cookbook.ui

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cookbook.R

class RecipeDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeNameTextView = view.findViewById<TextView>(R.id.detail_name)
        val recipeIngredientsTextView = view.findViewById<TextView>(R.id.detail_ingredients)
        val recipeInstructionsTextView = view.findViewById<TextView>(R.id.detail_instructions)
        val recipeRatingRatingBar = view.findViewById<RatingBar>(R.id.detail_rating)

        val args = arguments
        val recipeName = args?.getString("name")?: "Brak nazwy"
        val recipeIngredients = args?.getString("ingredients")?: "Brak składników"
        val recipeInstructions = args?.getString("instructions")?: "Brak instrukcji"
        val recipeRating = args?.getFloat("rating", 0f)?: 0f

        recipeNameTextView.text = "Nazwa przepisu: $recipeName"
        recipeIngredientsTextView.text = "Składniki: $recipeIngredients"
        recipeInstructionsTextView.text = "Instrukcja: $recipeInstructions"
        recipeRatingRatingBar.rating = recipeRating


//        val sharedPreferences = requireContext().getSharedPreferences("mojeDane", MODE_PRIVATE)
//        val recipesString = sharedPreferences.getString("recipes", "")
//
//        if(!recipesString.isNullOrEmpty()){
//            val recipesList = recipesString.split(";")
//            val lastRecipe = recipesList.lastOrNull()
//
//            lastRecipe?.let {
//                val recipeParts = it.split("|")
//                if(recipeParts.size == 4){
//                    recipeNameTextView.text = recipeParts[0]
//                    recipeIngredientsTextVie.text = recipeParts[1]
//                    recipeInstructionsTextView.text = recipeParts[2]
//                    recipeRatingBar.rating = recipeParts[3].toFloat()
//                }
//            }
//        }
    }


    companion object {
        fun newInstance(name: String, ingredients: String, instructions: String, rating: Float): RecipeDetailsFragment{
            val fragment = RecipeDetailsFragment()
            val args = Bundle()
            args.putString("name", name)
            args.putString("ingredients", ingredients)
            args.putString("instructions", instructions)
            args.putFloat("rating", rating)
            fragment.arguments = args
            return fragment
        }
    }
}