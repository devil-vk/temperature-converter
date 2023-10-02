package com.example.temperatureconvertor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var celsiusEditText: EditText
    private lateinit var fahrenheitEditText: EditText
    private lateinit var celsiusResultTextView: TextView
    private lateinit var fahrenheitResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celsiusEditText = findViewById(R.id.editTextNumberDecimal1)
        fahrenheitEditText = findViewById(R.id.editTextNumberDecimal2)
        celsiusResultTextView = findViewById(R.id.res1)
        fahrenheitResultTextView = findViewById(R.id.res2)

        val convertCelsiusButton: Button = findViewById(R.id.button)
        val convertFahrenheitButton: Button = findViewById(R.id.button2)

        convertCelsiusButton.setOnClickListener {
            convertToFahrenheit()
        }

        convertFahrenheitButton.setOnClickListener {
            convertToCelsius()
        }
    }

    private fun convertToCelsius() {
        val fahrenheitValue = fahrenheitEditText.text.toString().toDoubleOrNull()

        if (fahrenheitValue != null) {
            val celsiusValue = (fahrenheitValue - 32) * 5 / 9
            fahrenheitResultTextView.text = String.format("%.2f", celsiusValue)
        } else {
            fahrenheitResultTextView.text = "Invalid input"
        }
    }

    private fun convertToFahrenheit() {
        val celsiusValue = celsiusEditText.text.toString().toDoubleOrNull()

        if (celsiusValue != null) {
            val fahrenheitValue = (celsiusValue * 9 / 5) + 32
            celsiusResultTextView.text = String.format("%.2f", fahrenheitValue)
        } else {
            celsiusResultTextView.text = "Invalid input"
        }
    }
}
