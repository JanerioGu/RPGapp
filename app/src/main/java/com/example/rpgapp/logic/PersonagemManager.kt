package com.example.rpgapp.logic

import com.example.rpgapp.models.Atributos
import com.example.rpgapp.models.Raca

class PersonagemManager(val atributosHelper: AtributosHelper) {

    // Distribui os atributos com base nos valores informados e adiciona o valor base de 8
    fun distribuirAtributos(
        forca: Int, destreza: Int, constituicao: Int, inteligencia: Int, sabedoria: Int, carisma: Int
    ): Atributos {
        return Atributos(
            forca + 8, destreza + 8, constituicao + 8, inteligencia + 8, sabedoria + 8, carisma + 8
        )
    }

    // Aplica os bônus raciais
    fun aplicarBonusRacial(racaEscolhida: Raca, atributos: Atributos) {
        racaEscolhida.aplicarBonus(atributos)
    }

    // Calcula e aplica os modificadores nos atributos
    fun calcularEAtribuirModificadores(atributos: Atributos) {
        val modificadores = atributosHelper.aplicarModificadores(atributos)
        atributosHelper.aplicarModificadoresNosAtributos(atributos, modificadores)
    }
}
