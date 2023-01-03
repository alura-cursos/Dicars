package br.com.alura.dicars.model

import android.util.Log

class Motor {
    fun ligar() {
        val combustivel = Combustivel("álcool")
        if (combustivel.tipoCombustivel != "Etanol") {
            Log.i("Motor ligado", "Vamos rodar!")
        }
    }
}