package com.example.colorsbyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constrain_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        clickListeners()
    }

    private fun clickListeners(){
        val clickableViews: List<View> = listOf(findViewById(R.id.boxOne), findViewById(R.id.boxTwo),
            findViewById(R.id.boxThree), findViewById(R.id.boxFour), findViewById(R.id.boxFive), findViewById(R.id.constrain_layout))
        for(item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }

    }

    private fun makeColored(view: View) {
        when(view.id) {
            R.id.boxOne -> view.setBackgroundColor(Color.BLUE)
            R.id.boxTwo -> view.setBackgroundColor(Color.GRAY)
            R.id.boxThree -> view.setBackgroundColor(Color.MAGENTA)
            R.id.boxFour -> view.setBackgroundColor(Color.DKGRAY)
            R.id.boxFive -> view.setBackgroundResource(android.R.color.holo_purple)
            else -> view.setBackgroundResource(android.R.color.holo_blue_dark)
        }
    }
}