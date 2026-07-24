package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    
    private var selectedOperation: String = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1 = findViewById<EditText>(R.id.editTextNumberDecimal)
        val num2 = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val result = findViewById<TextView>(R.id.editTextNumber4)

        val btnAdd = findViewById<Button>(R.id.button3)
        val btnSub = findViewById<Button>(R.id.btnSubtract)
        val btnMul = findViewById<Button>(R.id.btnMultiply)
        val btnDiv = findViewById<Button>(R.id.btnDivide)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        fun performCalculation() {
            val s1 = num1.text.toString()
            val s2 = num2.text.toString()
            
            val a = s1.toDoubleOrNull()
            val b = s2.toDoubleOrNull()
            
            if (a != null && b != null) {
                when (selectedOperation) {
                    "+" -> result.text = (a + b).toString()
                    "-" -> result.text = (a - b).toString()
                    "*" -> result.text = (a * b).toString()
                    "/" -> {
                        if (b != 0.0) {
                            result.text = (a / b).toString()
                        } else {
                            result.text = "0.0"
                            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

        btnAdd.setOnClickListener { 
            selectedOperation = "+"
            performCalculation()
        }
        btnSub.setOnClickListener { 
            selectedOperation = "-"
            performCalculation()
        }
        btnMul.setOnClickListener { 
            selectedOperation = "*"
            performCalculation()
        }
        btnDiv.setOnClickListener { 
            selectedOperation = "/"
            performCalculation()
        }

        btnCalculate.setOnClickListener {
            performCalculation()
        }
    }
}
