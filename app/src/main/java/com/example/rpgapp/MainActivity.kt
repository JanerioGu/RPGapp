package com.example.rpgapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.rpgapp.logic.CriacaoPersonagem
import com.example.projetorpg2.kotlin.Raca

class MainActivity : ComponentActivity() {

    private lateinit var personagem: CriacaoPersonagem
    private lateinit var textAtributos: TextView
    private lateinit var buttonAtacar: Button
    private lateinit var buttonExibirVida: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando a classe CriacaoPersonagem
        personagem = CriacaoPersonagem()

        // Conectando as views do layout
        val spinnerRaca: Spinner = findViewById(R.id.spinner_race)
        textAtributos = findViewById(R.id.text_attributes)
        buttonAtacar = findViewById(R.id.button_attack)
        buttonExibirVida = findViewById(R.id.button_show_life)

        // Configurando o Spinner com as raças
        val racas = arrayOf(
            "Anões", "MeioOrc", "Humanos", "AltoElfo", "Draconato", "AnãoDaColina",
            "AnãoDaMontanha", "Drow", "ElfoDaFloresta", "Elfos", "Gnomo", "GnomoDaFloresta",
            "GnomoDasRochas", "Halflings", "HalflingPésLeves", "HalflingRobusto", "MeioElfo", "Tiefling"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, racas)
        spinnerRaca.adapter = adapter

        // Configurando o comportamento do Spinner
        spinnerRaca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Definindo a raça escolhida com base na posição selecionada no Spinner
                val racaEscolhida = when (position) {
                    0 -> Raca.Anões
                    1 -> Raca.MeioOrc
                    2 -> Raca.Humanos
                    3 -> Raca.AltoElfo
                    4 -> Raca.Draconato
                    5 -> Raca.AnãoDaColina
                    6 -> Raca.AnãoDaMontanha
                    7 -> Raca.Drow
                    8 -> Raca.ElfoDaFloresta
                    9 -> Raca.Elfos
                    10 -> Raca.Gnomo
                    11 -> Raca.GnomoDaFloresta
                    12 -> Raca.GnomoDasRochas
                    13 -> Raca.Halflings
                    14 -> Raca.HalflingPésLeves
                    15 -> Raca.HalflingRobusto
                    16 -> Raca.MeioElfo
                    17 -> Raca.Tiefling
                    else -> Raca.Humanos
                }

                // Iniciar o personagem com a raça escolhida
                personagem.iniciar(racaEscolhida)
                exibirAtributos() // Atualiza a exibição dos atributos na tela
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Não faz nada se nada for selecionado
            }
        }

        // Configuração do botão "Atacar"
        buttonAtacar.setOnClickListener {
            val resultadoAtaque = personagem.atacar()
            Toast.makeText(this, resultadoAtaque, Toast.LENGTH_SHORT).show() // Mostra o resultado do ataque
        }

        // Configuração do botão "Exibir Vida"
        buttonExibirVida.setOnClickListener {
            val vida = personagem.exibirVida()
            Toast.makeText(this, vida, Toast.LENGTH_SHORT).show() // Mostra a vida total
        }
    }

    // Função que atualiza o TextView com os atributos do personagem
    private fun exibirAtributos() {
        val atributos = personagem.atributos
        val atributosTexto = """
            Força: ${atributos.forca}
            Destreza: ${atributos.destreza}
            Constituição: ${atributos.constituicao}
            Inteligência: ${atributos.inteligencia}
            Sabedoria: ${atributos.sabedoria}
            Carisma: ${atributos.carisma}
        """.trimIndent()
        textAtributos.text = atributosTexto // Atualiza o TextView
    }
}
