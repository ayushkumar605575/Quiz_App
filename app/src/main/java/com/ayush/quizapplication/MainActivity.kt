package com.ayush.quizapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.ayush.quizapplication.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

const val NAME = "Name"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var checkedOpt: MaterialButton
    private lateinit var name: String
    private var points = 0
    private val questions = arrayListOf("Work attitudes can be reflected in an organization","Select the word which begins with a consonant.","Which word has a short /e/ sound?","Which word has a short /a/ sound?","Which word has a short /i/ sound?")
    private val options1 = arrayListOf("Job satisfaction","Organizational commitment","Both ‘A’ and ‘B’","None of the above")
    private val options2 = arrayListOf("Oven","Ink","Uniform","Kite")
    private val options3 = arrayListOf("Bad","Bee","Bed","None of the Above")
    private val options4 = arrayListOf("Cap","Cup","Cape","None of the Above")
    private val options5 = arrayListOf("Hit","Hie","Hive","None of the Above")
    private val answers = arrayListOf("None of the above","Oven","Bed","Cap","Hit")
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = intent.getStringExtra(NAME).toString()
        var qNumber = 1
        binding.headingTv.text = "Question $qNumber"
        binding.questionTv.text = questions[0]
        binding.aButton.text = options1[0]
        binding.bButton.text = options1[1]
        binding.cButton.text = options1[2]
        binding.dButton.text = options1[3]


        binding.myToggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                checkedOpt = binding.myToggleGroup.findViewById(checkedId)
                checkedOpt.setBackgroundColor(Color.GREEN)
                binding.nextBtn.isVisible = true
            }
            else {
                binding.myToggleGroup.findViewById<MaterialButton>(checkedId).setBackgroundColor(Color.WHITE)
            }
        }

        binding.nextBtn.setOnClickListener {
            if (binding.nextBtn.text == "Close App"){
                onDestroy()
            }
                answerCheck(checkedOpt.text.toString(),qNumber)
                qNumber+=1
                checkedOpt.setBackgroundColor(Color.WHITE)
                if (qNumber < 6) {
                    binding.headingTv.text = "Question $qNumber"
                }
                binding.myToggleGroup.clearChecked()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun answerCheck(ans: String, q_number: Int){
        when(q_number) {
            1 -> {
                if (ans == answers[0]){
                    points+=1
                }
                binding.questionTv.text = questions[1]
                binding.aButton.text = options2[0]
                binding.bButton.text = options2[1]
                binding.cButton.text = options2[2]
                binding.dButton.text = options2[3]
            }
            2 -> {
                if (ans == answers[q_number-1]){
                    points+=1
                }
                binding.questionTv.text = questions[2]
                binding.aButton.text = options3[0]
                binding.bButton.text = options3[1]
                binding.cButton.text = options3[2]
                binding.dButton.text = options3[3]
            }
            3 -> {
                if (ans == answers[q_number-1]){
                    points+=1
                }
                binding.questionTv.text = questions[2]
                binding.aButton.text = options4[0]
                binding.bButton.text = options4[1]
                binding.cButton.text = options4[2]
                binding.dButton.text = options4[3]
            }
            4 -> {
                if (ans == answers[q_number-1]){
                    points+=1
                }
                binding.questionTv.text = questions[2]
                binding.aButton.text = options5[0]
                binding.bButton.text = options5[1]
                binding.cButton.text = options5[2]
                binding.dButton.text = options5[3]
                binding.nextBtn.text = "Submit"
            }
            5 -> {
                if (ans == answers[q_number-1]){
                    points+=1
                }
                binding.headingTv.text = "Result"
                binding.questionTv.text = "$name\nYou scored $points points"
                binding.myToggleGroup.isVisible = false
                binding.nextBtn.text = "Close App"
            }
        }
    }

}