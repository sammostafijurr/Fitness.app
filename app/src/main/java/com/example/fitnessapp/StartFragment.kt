package com.example.fitnessapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class StartFragment : Fragment() {
   private lateinit var goButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =inflater.inflate(R.layout.fragment_start, container, false)
        goButton = v.findViewById(R.id.go_button)
        goButton.setOnClickListener { view : View ->
            Navigation.findNavController(view).navigate(R.id.action_startFragment_to_eexsizeFragment)
        setHasOptionsMenu(true)
        }
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) ||super.onOptionsItemSelected(item)
    }
}