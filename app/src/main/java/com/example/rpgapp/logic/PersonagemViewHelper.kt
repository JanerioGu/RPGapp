package com.example.rpgapp.logic

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class PersonagemViewHelper(private val activity: ComponentActivity) {

    // Função para exibir os atributos na tela
    fun exibirAtributos(
        textAtributos: TextView, raca: String?,
        forca: Int, destreza: Int, constituicao: Int,
        inteligencia: Int, sabedoria: Int, carisma: Int
    ) {
        val atributosTexto = """
            Raça: $raca
            Força: $forca
            Destreza: $destreza
            Constituição: $constituicao
            Inteligência: $inteligencia
            Sabedoria: $sabedoria
            Carisma: $carisma
        """.trimIndent()

        textAtributos.text = atributosTexto
    }

    // Função para lidar com o ataque
    fun configurarAtaque(buttonAtacar: Button) {
        buttonAtacar.setOnClickListener {
            Toast.makeText(activity, "Ataque realizado!", Toast.LENGTH_SHORT).show()
        }
    }

    // Função para lidar com a exibição da vida
    fun configurarExibirVida(buttonExibirVida: Button, constituicao: Int) {
        buttonExibirVida.setOnClickListener {
            val vida = calcularVida(constituicao)
            Toast.makeText(activity, "Vida Total: $vida", Toast.LENGTH_SHORT).show()
        }
    }

    // Cálculo da vida baseado na Constituição
    private fun calcularVida(constituicao: Int): Int {
        val baseVida = 10
        val modificador = (constituicao - 10) / 2
        return baseVida + modificador
    }
}
