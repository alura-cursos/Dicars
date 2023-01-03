package br.com.alura.dicars

import br.com.alura.dicars.model.Combustivel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

private const val TIPO_COMBUSTIVEL = "gasolina"

@Module
@InstallIn(ActivityComponent::class)
class CombustivelModule {

    @Provides
    fun provideCombustivel(): Combustivel{
        return Combustivel(TIPO_COMBUSTIVEL)
    }
}