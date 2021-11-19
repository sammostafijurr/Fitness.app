package com.example.fitnessapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import pl.droidsonroids.gif.GifImageView

class EexsizeFragment : Fragment() {
    data class Exercise(
        val exerciseType : String,
        val exerciseCount : Int
    )

    private val exercises : MutableList<Exercise> = mutableListOf(
        Exercise(exerciseType = "gifone", exerciseCount = 8 ),
        Exercise(exerciseType = "giftwo", exerciseCount = 5),
        Exercise(exerciseType = "gifthree", exerciseCount = 10),
        Exercise(exerciseType = "giffour",exerciseCount = 15),
        Exercise(exerciseType = "giffive", exerciseCount = 20)

    )
    lateinit var nextButton : Button
    lateinit var exitButton : Button
    lateinit var imageView : GifImageView
    lateinit var texvView : TextView

    private lateinit var currentExze : Exercise
     private var count : Int = 0
    private var exsizeIndex : Int = 0
    private var exsizeMal = Math.min((exercises.size+1)/2 , 3)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_eexsize, container, false)
        nextButton = v.findViewById(R.id.nextbutton)
        exitButton = v.findViewById(R.id.exitbutton)
        imageView = v.findViewById(R.id.exrze_image_view)
        texvView = v.findViewById(R.id.exsize_text_view)
        rdexse()
        return v
    }
 private fun rdexse(){
     exercises.shuffle()
    exsizeIndex = 0
    setExsize()
     nextButton.setOnClickListener { view:View ->
         exsizeIndex++
         if (exsizeIndex < exsizeMal){
             currentExze = exercises[exsizeIndex]
             setExsize()

         }else{
             view.findNavController().navigate(R.id.action_eexsizeFragment_to_wellDoneFragment)
         }

     }
     exitButton.setOnClickListener(
         Navigation.createNavigateOnClickListener(R.id.action_eexsizeFragment_to_tryAgainFragment)
     )
}
  private fun setExsize(){
      currentExze = exercises[exsizeIndex ]
      count = currentExze.exerciseCount
      texvView.text = String.format(getString(R.string.ex_text_view), count)
      imageView.setImageResource(resources.getIdentifier(currentExze.exerciseType
              , "drawable",(activity as AppCompatActivity).packageName))
      (activity as AppCompatActivity).supportActionBar?.title = String.format(getString(R.string.title_fitness_exercize),exsizeIndex+1,exsizeMal)

 }
}