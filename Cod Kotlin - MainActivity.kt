package com.calculadoraunibra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// Classe da tela inicial da aplicação.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referência ao botão "Iniciar"
        val btnStart = findViewById<Button>(R.id.btnStart)

        // Configura o botão para abrir a tela da calculadora
        btnStart.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent) // Abre a próxima tela
        }
    }
}
