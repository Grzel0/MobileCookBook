package com.example.cookbook.ui

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
    private lateinit var adapter: ListAdapter
    private val items = listOf("Sernik", "Spadżetti", "lazania", "boloneze")
    private lateinit var btnAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.recipe_list_view)
        adapter = ListAdapter(requireContext(), items)
        listView.adapter = adapter


        btnAdd = view.findViewById(R.id.add_recipe_button)
        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AddRecipeFragment()).addToBackStack(null).commit()
        }
    }





    companion object {

    }
}