package br.com.venturus.andrehlb.minipokedex.network

import br.com.venturus.andrehlb.minipokedex.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query



interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse
}
