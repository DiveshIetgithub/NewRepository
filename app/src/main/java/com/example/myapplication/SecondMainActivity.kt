package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySecondMainBinding

class SecondMainActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondMainBinding
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val fName =intent.getStringExtra("fName")
        val lName =intent.getStringExtra("lName")
        val mobile =intent.getStringExtra("mobile")
        val alt_mobile =intent.getStringExtra("alt_mobile")
        val email =intent.getStringExtra("email")
        val gender =intent.getStringExtra("gender")
        val Hobbies =intent.getStringExtra("Hobbies")

        binding.FullName.setText("$fName $lName")
        binding.Mobile.setText("$mobile")
        binding.Alter.setText("$alt_mobile")
        binding.Email.setText("$email")
       // binding.textViewGender.setText("$gender")
        binding.textViewGender.text = gender
      //  binding.textViewHobbies.setText("$Hobbies")

        val hobbies = intent.getStringExtra("hobbies")

        // Set the selected hobbies text to the TextView
        binding.hobbiesText.text = hobbies
    }
}