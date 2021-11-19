package com.example.fitnessapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class WellDoneFragment : Fragment() {
private lateinit var wellButton : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_well_done, container, false)
        wellButton = v.findViewById(R.id.nextworkoutButton)
        wellButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_wellDoneFragment_to_eexsizeFragment)
        )
        return v
    }

}