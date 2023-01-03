package br.com.alura.dicars.webclient

import retrofit2.Retrofit

class RetrofitInit {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://urlteste.com")
        .build()

    val carroService = retrofit.create(CarroService::class.java)
}
