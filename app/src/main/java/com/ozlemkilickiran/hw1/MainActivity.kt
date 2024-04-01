package com.ozlemkilickiran.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.ozlemkilickiran.hw1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val receivedIntent = intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.continueClick.setOnClickListener {
            val switchActivityIntent = Intent(this, MainActivity2::class.java)
            startActivity(switchActivityIntent)
        }

        val blinkingTitle= findViewById<TextView>(R.id.continueClick)
        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        blinkingTitle.startAnimation(anim)

    }
}