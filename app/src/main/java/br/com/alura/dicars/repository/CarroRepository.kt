package br.com.alura.dicars.repository

import br.com.alura.dicars.database.CarroDao
import br.com.alura.dicars.model.Carro
import br.com.alura.dicars.webclient.CarroWebClient
import javax.inject.Inject

class CarroRepository @Inject constructor(
    private val dao: CarroDao,
    private val webClient: CarroWebClient
) {
    suspend fun buscaTodos(): List<Carro> {
        val todosCarros: List<Carro> =
            dao.buscaTodos() + webClient.buscaCarros()
        return todosCarros.distinct()
    }

    suspend fun salva(carros: List<Carro>) {
        dao.salvaCarros(carros)
        webClient.insereCarros(carros)
    }
}