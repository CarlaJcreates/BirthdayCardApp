package com.example.birthdaycardapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("NAME")
        val day = intent.getIntExtra("DAY", 0)
        val month = intent.getIntExtra("MONTH", 0)
        val year = intent.getIntExtra("YEAR", 0)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val birthstoneTextView = findViewById<TextView>(R.id.birthstoneTextView)
        val zodiacTextView = findViewById<TextView>(R.id.zodiacTextView)
        val happy_birthday_result_text = findViewById<TextView>(R.id.happy_birthday_result_text)
        val userAge = calculateAge(year, month, day)

        nameTextView.text = "${name}"
        birthstoneTextView.text = "${getBirthstone(month)}"
        zodiacTextView.text = "${getChineseZodiac(year)}"

        happy_birthday_result_text.text = "Happy ${userAge}${getAgeSuffix(userAge)} Birthday!"
    }

    private fun calculateAge(year: Int, month: Int, day: Int): Int {
        val today = Calendar.getInstance()
        val birthDate = Calendar.getInstance().apply {
            set(year, month, day)
        }
        var age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)
        if (today.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age
    }

    private fun getBirthstone(month: Int): String {
        val birthstones = arrayOf(
            "Garnet", "Amethyst", "Aquamarine", "Diamond",
            "Emerald", "Alexandrite", "Ruby", "Peridot",
            "Sapphire", "Opal", "Topaz", "Turquoise"
        )
        return birthstones[month]
    }

    private fun getChineseZodiac(year: Int): String {
        val zodiacs = arrayOf(
            "Rat", "Ox", "Tiger", "Rabbit",
            "Dragon", "Snake", "Horse", "Goat",
            "Monkey", "Rooster", "Dog", "Pig"
        )
        return zodiacs[(year - 4) % 12]
    }

    private fun getAgeSuffix(age: Int): String {
        return if (age in 11..13) {
            "th"
        } else {
            when (age % 10) {
                1 -> "st"
                2 -> "nd"
                3 -> "rd"
                else -> "th"
            }
        }
    }
}
