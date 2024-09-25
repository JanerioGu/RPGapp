package com.example.rpgapp.logic

import com.example.projetorpg2.kotlin.Raca
import com.example.rpgapp.models.Atributos
import com.example.rpgapp.models.AtributosModificadores
import kotlin.random.Random

class CriacaoPersonagem {
    val atributos = Atributos()
    val atributosModificadores = AtributosModificadores()

    fun iniciar(raca: Raca) {
        raca.aplicarBonus(atributos)
        atributosModificadores.atualizarModificadores(atributos)
    }

    fun atacar(): String {
        val dado = Random.nextInt(1, 7)
        val totalForca = atributosModificadores.forca
        val hit = dado + totalForca
        return if (hit > 0) {
            "Acertou! Você deu $hit de dano"
        } else {
            "Você errou!"
        }
    }

    fun exibirVida(): String {
        val vidaBase = 10
        val constituicaoFinal = atributos.constituicao + atributosModificadores.constituicao
        val modificadorConstituicao = atributosModificadores.calcularModificador(constituicaoFinal)
        val vidaTotal = vidaBase + modificadorConstituicao
        return "Vida Total: $vidaTotal"
    }
}
