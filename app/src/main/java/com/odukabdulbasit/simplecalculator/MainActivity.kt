package com.odukabdulbasit.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private var currentNumber = ""
    private var currentOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        currentNumber += button.text
        textViewResult.text = currentNumber
    }

    fun onOperationClick(view: View) {
        val button = view as Button
        currentOperator = button.text.toString()
        currentNumber = ""
    }

    fun onEqualsClick(view: View) {
        val number1 = currentNumber.toDoubleOrNull() ?: return
        val number2 = textViewResult.text.toString().toDoubleOrNull() ?: return

        val result = when (currentOperator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
            else -> return
        }

        textViewResult.text = result.toString()
        currentNumber = result.toString()
    }
}
