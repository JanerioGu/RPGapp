package com.example.projetorpg2.kotlin

import com.example.rpgapp.models.Atributos

sealed class Raca {

    abstract fun aplicarBonus(atributos: Atributos)

    object AltoElfo : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Alto Elfo:")
            exibirAtributos(atributos)
        }
    }

    object AnãoDaColina : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.sabedoria += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Anão da Colina:")
            exibirAtributos(atributos)
        }
    }

    object AnãoDaMontanha : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Anão da Montanha:")
            exibirAtributos(atributos)
        }
    }

    object Anões : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.constituicao += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Anão:")
            exibirAtributos(atributos)
        }
    }

    object Drow : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.carisma += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Anão:")
            exibirAtributos(atributos)
        }
    }

    object Draconato : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.carisma += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Draconato:")
            exibirAtributos(atributos)
        }
    }

    object ElfoDaFloresta : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.sabedoria += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Elfo da Floresta:")
            exibirAtributos(atributos)
        }
    }

    object Elfos : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Elfo:")
            exibirAtributos(atributos)
        }
    }

    object Gnomo : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Gnomo:")
            exibirAtributos(atributos)
        }
    }

    object GnomoDaFloresta : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Gnomo da Floresta:")
            exibirAtributos(atributos)
        }
    }

    object GnomoDasRochas : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.constituicao += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Gnomo das Rochas:")
            exibirAtributos(atributos)
        }
    }

    object HalflingPésLeves : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.carisma += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Halfling Pés Leves:")
            exibirAtributos(atributos)
        }
    }

    object HalflingRobusto : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.constituicao += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Halfling Robusto:")
            exibirAtributos(atributos)
        }
    }

    object Halflings : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.destreza += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Halfling:")
            exibirAtributos(atributos)
        }
    }

    object Humanos : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 1
            atributos.destreza += 1
            atributos.constituicao += 1
            atributos.inteligencia += 1
            atributos.sabedoria += 1
            atributos.carisma += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Humano:")
            exibirAtributos(atributos)
        }
    }

    object MeioElfo : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.carisma += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Meio Elfo:")
            exibirAtributos(atributos)
        }
    }

    object MeioOrc : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.forca += 2
            atributos.constituicao += 1
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Meio Orc:")
            exibirAtributos(atributos)
        }
    }

    object Tiefling : Raca() {
        override fun aplicarBonus(atributos: Atributos) {
            atributos.inteligencia += 1
            atributos.carisma += 2
        }

        fun mostrarAtributos(atributos: Atributos) {
            println("Atributos do Tiefling:")
            exibirAtributos(atributos)
        }
    }

    // Método auxiliar para exibir os atributos de qualquer raça
    fun exibirAtributos(atributos: Atributos) {
        println("Força: ${atributos.forca}")
        println("Destreza: ${atributos.destreza}")
        println("Constituição: ${atributos.constituicao}")
        println("Inteligência: ${atributos.inteligencia}")
        println("Sabedoria: ${atributos.sabedoria}")
        println("Carisma: ${atributos.carisma}")
    }
}


