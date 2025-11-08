package br.com.venturus.andrehlb.minipokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default")
    val frontDefault: String?
)