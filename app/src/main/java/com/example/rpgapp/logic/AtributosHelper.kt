package com.example.rpgapp.logic

import com.example.rpgapp.models.Atributos
import com.example.rpgapp.models.AtributosModificadores

class AtributosHelper {

    // Calcula o custo total de pontos distribuídos
    fun calcularCustoTotal(atributos: Map<String, Int>): Int {
        // Aqui somamos todos os valores fornecidos
        return atributos.values.sum()
    }

    // Atualiza os modificadores e os aplica aos atributos
    fun aplicarModificadores(atributos: Atributos): AtributosModificadores {
        val modificadores = AtributosModificadores()
        modificadores.atualizarModificadores(atributos)
        return modificadores
    }

    // Aplica os modificadores de atributos diretamente nos valores de Atributos
    fun aplicarModificadoresNosAtributos(atributos: Atributos, modificadores: AtributosModificadores) {
        atributos.forca += modificadores.forca
        atributos.destreza += modificadores.destreza
        atributos.constituicao += modificadores.constituicao
        atributos.inteligencia += modificadores.inteligencia
        atributos.sabedoria += modificadores.sabedoria
        atributos.carisma += modificadores.carisma
    }
}
