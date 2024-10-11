package com.example.rpgapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.rpgapp.R
import com.example.rpgapp.logic.PersonagemViewHelper
import android.widget.TextView
import android.widget.Button

class PersonagemActivity : ComponentActivity() {

    private lateinit var textAtributos: TextView
    private lateinit var buttonAtacar: Button
    private lateinit var buttonExibirVida: Button

    private lateinit var personagemViewHelper: PersonagemViewHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagem)

        // Inicializar os componentes da UI
        textAtributos = findViewById(R.id.text_attributes_personagem)
        buttonAtacar = findViewById(R.id.button_atacar_personagem)
        buttonExibirVida = findViewById(R.id.button_exibir_vida_personagem)

        // Inicializar o helper para gerenciar a lógica de exibição
        personagemViewHelper = PersonagemViewHelper(this)

        // Receber os valores da intent
        val forca = intent.getIntExtra("forca", 0)
        val destreza = intent.getIntExtra("destreza", 0)
        val constituicao = intent.getIntExtra("constituicao", 0)
        val inteligencia = intent.getIntExtra("inteligencia", 0)
        val sabedoria = intent.getIntExtra("sabedoria", 0)
        val carisma = intent.getIntExtra("carisma", 0)
        val raca = intent.getStringExtra("raca")

        // Exibir os atributos
        personagemViewHelper.exibirAtributos(
            textAtributos, raca, forca, destreza,
            constituicao, inteligencia, sabedoria, carisma
        )

        // Configurar os botões de ação
        personagemViewHelper.configurarAtaque(buttonAtacar)
        personagemViewHelper.configurarExibirVida(buttonExibirVida, constituicao)
    }
}
