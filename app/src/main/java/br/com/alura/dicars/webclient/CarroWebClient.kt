package br.com.alura.dicars.webclient

import br.com.alura.dicars.model.Carro
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CarroWebClient @Inject constructor (
    private val carroService: CarroService
) {
    suspend fun buscaCarros(): List<Carro> {
        return try {
            carroService.buscaTodos().first()
        } catch (e: Exception) {
            listOf(Carro("www-404", "Carro Online"))
        }
    }

    fun insereCarros(carros: List<Carro>) {
        carroService.salvaCarros(carros)
    }
}