package br.com.alura.dicars

import br.com.alura.dicars.model.Carro

data class ListaCarrosUitState(
    val carros: List<Carro> = emptyList()
)