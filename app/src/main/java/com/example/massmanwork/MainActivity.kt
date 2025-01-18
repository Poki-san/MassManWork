package com.example.massmanwork

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.round
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var oneNumberET:EditText
    private lateinit var twoNumberET:EditText

    private lateinit var oneNumberErr:TextView
    private lateinit var twoNumberErr:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        oneNumberET = findViewById(R.id.oneNumberET)
        twoNumberET = findViewById(R.id.twoNumberET)

        oneNumberErr = findViewById(R.id.oneNumberErr)
        twoNumberErr = findViewById(R.id.twoNumberErr)
    }

    fun onClick(view: View){
        val height = oneNumberET.text.toString().toDoubleOrNull()
        val weight = twoNumberET.text.toString().toDoubleOrNull()

        if (height == null || height > 250.0 || height < 130.0){
            oneNumberErr.text = "Не корректный рост"
            return
        }

        if ( weight==null || weight > 500.0 || weight < 35.0){
            twoNumberErr.text = "Не корректный рост"
            return
        }
        val bmi = onBmiCalc(weight, height)
        val intent = Intent(this, SecondScreen::class.java)
        intent.putExtra("bmi", bmi)
        startActivity(intent)
    }

    private fun onBmiCalc(weight:Double, height:Double): String {
        val heightMetre = height/100
        return  round(weight / (heightMetre*heightMetre)).toString()
    }
}