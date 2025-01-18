package com.example.massmanwork

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {
    private lateinit var imageType:ImageView
    private lateinit var titleTV:TextView
    private lateinit var typeTV:TextView
    private lateinit var descTV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageType = findViewById(R.id.imageType)
        titleTV = findViewById(R.id.titleTV)
        typeTV = findViewById(R.id.typeTV)
        descTV = findViewById(R.id.descTV)
        onInitial()
    }

    @SuppressLint("SetTextI18n")
    private fun onInitial(){
        val bmi = intent.getStringExtra("bmi")!!.toDouble()
        val bmiPair = getBMIInf(bmi)
        imageType.setImageResource(bmiPair.first)
        titleTV.text = "Ваш индекс: $bmi"
        typeTV.text = bmiPair.second.title
        descTV.text = bmiPair.second.desc
    }

    private fun getBMIInf(bmi:Double):Pair<Int,bmiInfo>{
        return when(bmi){
            in 0.0..<18.5 -> Pair(R.drawable.one, database().one)
            in 18.5..<24.9 -> Pair(R.drawable.two, database().two)
            else -> Pair(R.drawable.three, database().three)
        }
    }
}