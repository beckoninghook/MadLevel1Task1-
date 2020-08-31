package com.example.madlevel1task1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    
    private fun initViews() {
        val higherBtn = findViewById<Button>(R.id.higher)
        higherBtn.setOnClickListener(){
            onHigherClick()
        }

        val lowerBtn = findViewById<Button>(R.id.lower)
        lowerBtn.setOnClickListener(){
            onLowerClick()
        }

        val equalBtn = findViewById<Button>(R.id.equals)
        equalBtn.setOnClickListener(){
            onEqualClick()
        }
        updateUI()
    }

    private fun updateUI() {
        binding.lastThrow.text = getString(R.string.last_throw , lastThrow)
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        val diceImageView = binding.imageView;
        when (currentThrow) {
            1 ->  diceImageView.setImageResource(R.drawable.dice1)
            2 ->  diceImageView.setImageResource(R.drawable.dice2)
            3 -> diceImageView.setImageResource(R.drawable.dice3)
            4 -> diceImageView.setImageResource(R.drawable.dice4)
            5 -> diceImageView.setImageResource(R.drawable.dice5)
            6 -> diceImageView.setImageResource(R.drawable.dice6)
        }
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()

        if (lastThrow > currentThrow){
            onAnswerCorrect()
        }else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if (lastThrow < currentThrow){
            onAnswerCorrect()
        }else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()
        if (lastThrow == currentThrow){
            onAnswerCorrect()
        }else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        Toast.makeText(applicationContext, "u won", Toast.LENGTH_LONG).show()
    }


    private fun onAnswerIncorrect() {
        Toast.makeText(applicationContext, "u lost", Toast.LENGTH_LONG).show()
    }


}