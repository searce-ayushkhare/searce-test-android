package com.example.testsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testsample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSecond.setOnClickListener {
            onBackPressed()
        }

        var emailAddresses = binding.emailAddr.text.toString().split(",".toRegex()).toTypedArray()
        var subject = binding.emailSubj.text.toString()
        var body = binding.emailBody.text.toString()

        println(body)

        // jumping to email app on button click
        binding.buttonSecond2.setOnClickListener {
            Toast.makeText(this, "Sending mail...", Toast.LENGTH_SHORT).show()

            var intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")

                putExtra(Intent.EXTRA_EMAIL, emailAddresses)
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }

            startActivity(intent)
        }
    }
}