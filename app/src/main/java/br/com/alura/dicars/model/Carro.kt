package br.com.alura.dicars.model

class Carro (private val motor: Motor) {
    fun darPartida() {
        motor.ligar()
    }
}