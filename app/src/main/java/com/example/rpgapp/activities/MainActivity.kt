package com.example.rpgapp.activities

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.rpgapp.R
import com.example.rpgapp.models.Raca
import com.google.android.filament.View

class MainActivity : ComponentActivity() {

    private lateinit var textBonusRace: TextView
    private lateinit var spinnerRaca: Spinner
    private var racaEscolhida: Raca = Raca.Humanos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textBonusRace = findViewById(R.id.text_bonus_race)
        spinnerRaca = findViewById(R.id.spinner_race)

        val racas = listOf(
            Raca.Humanos,
            Raca.Anoes,
            Raca.AltoElfo,
            Raca.Drow,
            Raca.Draconato,
            Raca.ElfoDaFloresta,
            Raca.GnomoDasRochas,
            Raca.HalflingPésLeves,
            Raca.MeioOrc,
            Raca.Tiefling
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, racas.map { it.toString() })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRaca.adapter = adapter

        spinnerRaca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                racaEscolhida = racas[position]
                mostrarBonusRaca(racaEscolhida)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    // Função para exibir os bônus de cada raça
    private fun mostrarBonusRaca(raca: Raca) {
        val bonusTexto = when (raca) {
            Raca.Humanos -> "+1 em todos os atributos (Força, Destreza, Constituição, Inteligência, Sabedoria, Carisma)"
            Raca.Anoes -> "+2 em Constituição"
            Raca.AnãoDaColina -> "+2 em Constituição, +1 em Sabedoria"
            Raca.AnãoDaMontanha -> "+2 em Constituição, +2 em Força"
            Raca.AltoElfo -> "+2 em Destreza, +1 em Inteligência"
            Raca.Drow -> "+2 em Destreza, +1 em Carisma"
            Raca.Draconato -> "+2 em Força, +1 em Carisma"
            Raca.ElfoDaFloresta -> "+2 em Destreza, +1 em Sabedoria"
            Raca.GnomoDasRochas -> "+2 em Inteligência, +1 em Constituição"
            Raca.Gnomo -> "+2 em Inteligência"
            Raca.GnomoDaFloresta -> "+2 em Inteligência, +1 em Destreza"
            Raca.HalflingPésLeves -> "+2 em Destreza, +1 em Carisma"
            Raca.HalflingRobusto -> "+2 em Destreza, +1 em Constituição"
            Raca.Halflings -> "+2 em Destreza"
            Raca.MeioOrc -> "+2 em Força, +1 em Constituição"
            Raca.MeioElfo -> "+2 em Carisma, +1 em dois outros atributos à escolha"
            Raca.Tiefling -> "+1 em Inteligência, +2 em Carisma"
        }
        textBonusRace.text = "Bônus: $bonusTexto"
    }

}
