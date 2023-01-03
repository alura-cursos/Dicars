package br.com.alura.dicars.webclient

import br.com.alura.dicars.model.Carro
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.PUT

interface CarroService {

    @GET("carros")
    fun buscaTodos(): Flow<List<Carro>>

    @PUT("carros")
    fun salvaCarros(carros: List<Carro>)
}