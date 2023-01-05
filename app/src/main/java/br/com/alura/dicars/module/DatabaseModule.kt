package br.com.alura.dicars.module

import android.content.Context
import br.com.alura.dicars.database.CarroDao
import br.com.alura.dicars.database.DicarsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideCarroDao(@ApplicationContext context: Context): CarroDao{
        return DicarsDatabase.getDatabase(context).CarroDao()
    }
}