package br.com.alura.dicars.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.dicars.model.Carro

@Database(entities = [Carro::class], version = 1)
abstract class DicarsDatabase : RoomDatabase() {
    abstract fun CarroDao(): CarroDao

    companion object {
        fun getDatabase(context: Context): DicarsDatabase {
            return Room.databaseBuilder(
                context,
                DicarsDatabase::class.java,
                "Dicars.db"
            ).build()
        }
    }
}