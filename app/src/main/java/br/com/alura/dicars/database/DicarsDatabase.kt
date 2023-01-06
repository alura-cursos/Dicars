package br.com.alura.dicars.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.alura.dicars.model.Carro

@Database(entities = [Carro::class], version = 1)
abstract class DicarsDatabase : RoomDatabase() {
    abstract fun CarroDao(): CarroDao
}