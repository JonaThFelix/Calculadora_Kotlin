package com.calculadoraunibra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// Classe responsável pela tela de cálculo do IMC.
class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // Referências aos elementos do layout
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Configura o botão para calcular o IMC
        btnCalculate.setOnClickListener {
            val weightText = etWeight.text.toString()
            val heightText = etHeight.text.toString()

            // Verifica se os campos estão preenchidos
            if (weightText.isEmpty() || heightText.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Converte os valores e realiza o cálculo
            val weight = weightText.toFloatOrNull()
            val height = heightText.toFloatOrNull()

            if (weight == null || height == null || height == 0f) {
                Toast.makeText(this, "Valores inválidos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val imc = weight / (height * height)

            // Classificação do IMC
	   // Não achei necessário expandir para obesidade e seus graus, como 1, 2, 3 ...

            val classification = when {
                imc < 18.5 -> "Abaixo do peso"
                imc in 18.5..24.9 -> "Peso normal"
                imc in 25.0..29.9 -> "Sobrepeso"
                else -> "Obesidade"
            }

            // Exibe o resultado na tela
            tvResult.text = "Seu IMC é %.2f\nClassificação: %s".format(imc, classification)
        }
    }
}
