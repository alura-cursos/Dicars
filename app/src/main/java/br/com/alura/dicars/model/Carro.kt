package br.com.alura.dicars.model

import javax.inject.Inject

class Carro @Inject constructor(private val motor: Motor) {
    fun darPartida() {
        motor.ligar()
    }
}