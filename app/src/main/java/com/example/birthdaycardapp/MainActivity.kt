package com.example.birthdaycardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val birthdayDatePicker = findViewById<DatePicker>(R.id.birthdayDatePicker)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val day = birthdayDatePicker.dayOfMonth
            val month = birthdayDatePicker.month
            val year = birthdayDatePicker.year

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("NAME", name)
                putExtra("DAY", day)
                putExtra("MONTH", month)
                putExtra("YEAR", year)
            }
            startActivity(intent)
        }
    }
}
