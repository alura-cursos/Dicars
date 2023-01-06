package br.com.alura.dicars.module

import android.content.Context
import androidx.room.Room
import br.com.alura.dicars.database.CarroDao
import br.com.alura.dicars.database.DicarsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "Dicars.db"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DicarsDatabase {
        return Room.databaseBuilder(
            context,
            DicarsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideCarroDao(db: DicarsDatabase): CarroDao {
        return db.CarroDao()
    }
}