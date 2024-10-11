// Raca sealed class
package com.example.rpgapp.models

import com.example.rpgapp.models.Atributos

sealed class Raca {

    abstract fun aplicarBonus(atributos: Atributos)
    abstract override fun toString(): String

    object Humanos : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 1
            atributos.destreza += 1
            atributos.constituicao += 1
            atributos.inteligencia += 1
            atributos.sabedoria += 1
            atributos.carisma += 1
        }

        override fun toString(): String = "Humanos"
    }

    object Anoes : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.constituicao += 2
        }

        override fun toString(): String = "Anões"
    }

    object AltoElfo : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 1
            atributos.destreza += 2
        }

        override fun toString(): String = "Alto Elfo"
    }

    object Drow : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 2
            atributos.carisma += 1
        }

        override fun toString(): String = "Drow"
    }

    object Draconato : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 2
            atributos.carisma += 1
        }

        override fun toString(): String = "Draconato"
    }

    object ElfoDaFloresta : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 2
            atributos.sabedoria += 1
        }

        override fun toString(): String = "Elfo da Floresta"
    }

    object GnomoDasRochas : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 2
            atributos.constituicao += 1
        }

        override fun toString(): String = "Gnomo das Rochas"
    }

    object HalflingPésLeves : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 2
            atributos.carisma += 1
        }

        override fun toString(): String = "Halfling Pés Leves"
    }

    object MeioOrc : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 2
            atributos.constituicao += 1
        }

        override fun toString(): String = "Meio Orc"
    }

    object Tiefling : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 1
            atributos.carisma += 2
        }

        override fun toString(): String = "Tiefling"
    }

    // Raças faltantes
    object AnãoDaColina : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.sabedoria += 1
        }

        override fun toString(): String = "Anão da Colina"
    }

    object AnãoDaMontanha : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 2
        }

        override fun toString(): String = "Anão da Montanha"
    }

    object Gnomo : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 2
        }

        override fun toString(): String = "Gnomo"
    }

    object GnomoDaFloresta : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 1
        }

        override fun toString(): String = "Gnomo da Floresta"
    }

    object HalflingRobusto : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.constituicao += 1
        }

        override fun toString(): String = "Halfling Robusto"
    }

    object Halflings : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 2
        }

        override fun toString(): String = "Halflings"
    }

    object MeioElfo : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.carisma += 2
        }

        override fun toString(): String = "Meio Elfo"
    }

    // Método auxiliar para exibir os atributos de qualquer raça
    fun exibirAtributos(atributos: Atributos) {
        println("Atributos:")
        println("Força: ${atributos.forca}")
        println("Destreza: ${atributos.destreza}")
        println("Constituição: ${atributos.constituicao}")
        println("Inteligência: ${atributos.inteligencia}")
        println("Sabedoria: ${atributos.sabedoria}")
        println("Carisma: ${atributos.carisma}")
    }
}
