package com.example.rpgapp.logic

import com.example.rpgapp.models.Raca
import com.example.rpgapp.models.Atributos
import com.example.rpgapp.models.AtributosModificadores

class CriacaoPersonagem {
    var atributos = Atributos()
    var raca: Raca? = null
    private val atributosModificadores = AtributosModificadores()

    fun iniciar(raca: Raca, atributosDistribuidos: Atributos) {
        this.raca = raca
        this.atributos = atributosDistribuidos
        raca.aplicarBonus(atributos)
        atributosModificadores.atualizarModificadores(atributos)
    }
}