package com.example.rpgapp.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.rpgapp.R
import com.example.rpgapp.logic.AtributosHelper
import com.example.rpgapp.logic.PersonagemManager
import com.example.rpgapp.models.Raca
import com.example.rpgapp.models.Atributos

class MainActivity : ComponentActivity() {

    private lateinit var personagemManager: PersonagemManager
    private lateinit var buttonCriarPersonagem: Button
    private lateinit var pontosRestantesTextView: TextView
    private lateinit var textBonusRace: TextView // Adicionei esse TextView para exibir os bônus da raça
    private var racaEscolhida: Raca = Raca.Humanos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val atributosHelper = AtributosHelper()
        personagemManager = PersonagemManager(atributosHelper)

        val forcaInput: EditText = findViewById(R.id.edit_forca)
        val destrezaInput: EditText = findViewById(R.id.edit_destreza)
        val constituicaoInput: EditText = findViewById(R.id.edit_constituicao)
        val inteligenciaInput: EditText = findViewById(R.id.edit_inteligencia)
        val sabedoriaInput: EditText = findViewById(R.id.edit_sabedoria)
        val carismaInput: EditText = findViewById(R.id.edit_carisma)

        pontosRestantesTextView = findViewById(R.id.text_pontos_restantes)
        textBonusRace = findViewById(R.id.text_bonus_race) // Inicializando o TextView dos bônus da raça
        buttonCriarPersonagem = findViewById(R.id.button_create_character)

        atualizarPontosRestantes()
        adicionarTextWatcher(
            forcaInput,
            destrezaInput,
            constituicaoInput,
            inteligenciaInput,
            sabedoriaInput,
            carismaInput
        )

        val spinnerRaca: Spinner = findViewById(R.id.spinner_race)
        configurarSpinnerRacas(spinnerRaca)

        buttonCriarPersonagem.setOnClickListener {
            val atributosDistribuidos = personagemManager.distribuirAtributos(
                forcaInput.text.toString().toIntOrNull() ?: 0,
                destrezaInput.text.toString().toIntOrNull() ?: 0,
                constituicaoInput.text.toString().toIntOrNull() ?: 0,
                inteligenciaInput.text.toString().toIntOrNull() ?: 0,
                sabedoriaInput.text.toString().toIntOrNull() ?: 0,
                carismaInput.text.toString().toIntOrNull() ?: 0
            )

            personagemManager.aplicarBonusRacial(racaEscolhida, atributosDistribuidos)
            personagemManager.calcularEAtribuirModificadores(atributosDistribuidos)

            enviarDadosParaPersonagemActivity(atributosDistribuidos)
        }
    }

    private fun configurarSpinnerRacas(spinner: Spinner) {
        val racas = listOf(
            Raca.Humanos, Raca.Anoes, Raca.AltoElfo, Raca.Drow, Raca.Draconato,
            Raca.ElfoDaFloresta, Raca.GnomoDasRochas, Raca.HalflingPésLeves,
            Raca.MeioOrc, Raca.Tiefling, Raca.AnãoDaColina, Raca.AnãoDaMontanha,
            Raca.Gnomo, Raca.GnomoDaFloresta, Raca.HalflingRobusto, Raca.Halflings, Raca.MeioElfo
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, racas.map { it.toString() })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                racaEscolhida = racas[position]
                mostrarBonusRaca(racaEscolhida) // Exibe os bônus da raça no TextView
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    // Função para exibir os bônus de cada raça no TextView
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

    private fun adicionarTextWatcher(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val value = s.toString().toIntOrNull() ?: 0
                    if (value > 7) {
                        editText.setText("7")
                        editText.setSelection(editText.text.length)
                        Toast.makeText(this@MainActivity, "O valor máximo é 7", Toast.LENGTH_SHORT).show()
                    }
                    atualizarPontosRestantes()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }

    private fun enviarDadosParaPersonagemActivity(atributos: Atributos) {
        val intent = Intent(this, PersonagemActivity::class.java).apply {
            putExtra("forca", atributos.forca)
            putExtra("destreza", atributos.destreza)
            putExtra("constituicao", atributos.constituicao)
            putExtra("inteligencia", atributos.inteligencia)
            putExtra("sabedoria", atributos.sabedoria)
            putExtra("carisma", atributos.carisma)
            putExtra("raca", racaEscolhida.toString())
        }
        startActivity(intent)
    }

    private fun atualizarPontosRestantes() {
        val forca = findViewById<EditText>(R.id.edit_forca).text.toString().toIntOrNull() ?: 0
        val destreza = findViewById<EditText>(R.id.edit_destreza).text.toString().toIntOrNull() ?: 0
        val constituicao = findViewById<EditText>(R.id.edit_constituicao).text.toString().toIntOrNull() ?: 0
        val inteligencia = findViewById<EditText>(R.id.edit_inteligencia).text.toString().toIntOrNull() ?: 0
        val sabedoria = findViewById<EditText>(R.id.edit_sabedoria).text.toString().toIntOrNull() ?: 0
        val carisma = findViewById<EditText>(R.id.edit_carisma).text.toString().toIntOrNull() ?: 0

        val atributos = mapOf(
            "forca" to forca,
            "destreza" to destreza,
            "constituicao" to constituicao,
            "inteligencia" to inteligencia,
            "sabedoria" to sabedoria,
            "carisma" to carisma
        )

        val totalCusto = personagemManager.atributosHelper.calcularCustoTotal(atributos)

        val pontosRestantes = 27 - totalCusto
        pontosRestantesTextView.text = "Pontos restantes: $pontosRestantes"
        buttonCriarPersonagem.isEnabled = pontosRestantes >= 0
    }
}
