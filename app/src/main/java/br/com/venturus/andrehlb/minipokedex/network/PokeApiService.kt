package br.com.venturus.andrehlb.minipokedex.network

import br.com.venturus.andrehlb.minipokedex.model.PokemonResponse
import retrofit2.http.GET

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonResponse
}
