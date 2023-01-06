package br.com.alura.dicars.module

import br.com.alura.dicars.webclient.CarroService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://urlteste.com"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideCarroService(retrofit: Retrofit): CarroService {
        return retrofit.create(CarroService::class.java)
    }
}