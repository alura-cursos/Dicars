package br.com.alura.dicars.model

import android.util.Log
import javax.inject.Inject

class Motor @Inject constructor (private val combustivel: Combustivel) {
    fun ligar() {
        if (combustivel.tipoCombustivel != "Etanol") {
            Log.i("Motor ligado", "Vamos rodar!")
        }
    }
}