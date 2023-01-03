package br.com.alura.dicars.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Carro(
    @PrimaryKey
    val placa: String = "",
    val modelo: String = ""
)
