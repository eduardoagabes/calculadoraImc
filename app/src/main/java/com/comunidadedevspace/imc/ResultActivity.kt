package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        var color: Int
        val classificacao: String

        if (result <= 18.5f) {
            color = ContextCompat.getColor(this, R.color.red)
            classificacao = "MAGREZA"
        } else if (result <= 24.9f) {
            color = ContextCompat.getColor(this, R.color.green)
            classificacao = "NORMAL"
        } else if (result <= 29.9f) {
            color = ContextCompat.getColor(this, R.color.yellow)
            classificacao = "SOBREPESO"
        } else if (result <= 39.9f) {
            color = ContextCompat.getColor(this, R.color.red)
            classificacao = "OBESIDADE"
        } else {
            color = ContextCompat.getColor(this, R.color.red)
            classificacao = "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(color)
    }
}
