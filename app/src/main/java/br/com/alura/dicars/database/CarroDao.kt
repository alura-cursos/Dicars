package br.com.alura.dicars.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.dicars.model.Carro

@Dao
interface CarroDao {
    @Query("SELECT * FROM Carro")
    suspend fun buscaTodos(): List<Carro>

    @Insert
    suspend fun salvaCarros(Carros: List<Carro>)
}