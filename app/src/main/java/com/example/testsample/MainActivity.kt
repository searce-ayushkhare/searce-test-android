package com.example.testsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val launchIntent = intent
        if (launchIntent.action == "com.google.intent.action.TEST_LOOP") {
            val scenario = launchIntent.getIntExtra("scenario", 0)
            // Code to handle your game loop here
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigating to the new activity to draft email
        binding.buttonMain.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        MainActivity().finish();
    }
}