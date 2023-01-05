package br.com.alura.dicars.module

import br.com.alura.dicars.webclient.CarroService
import br.com.alura.dicars.webclient.RetrofitInit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideCarroService(): CarroService{
        return RetrofitInit().carroService
    }
}