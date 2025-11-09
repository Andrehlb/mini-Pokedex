package br.com.venturus.andrehlb.minipokedex.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String> = emptyList(),  // Lista de tipos (Fire, Water, etc)
    val generation: Int = 0  // Geração calculada baseada no ID
) : Parcelable {

    companion object {
        // Função auxiliar para determinar a geração baseada no ID do Pokemon
        fun getGenerationFromId(id: Int): Int {
            return when (id) {
                in 1..151 -> 1      // Gen I (Kanto)
                in 152..251 -> 2    // Gen II (Johto)
                in 252..386 -> 3    // Gen III (Hoenn)
                in 387..493 -> 4    // Gen IV (Sinnoh)
                in 494..649 -> 5    // Gen V (Unova)
                in 650..721 -> 6    // Gen VI (Kalos)
                in 722..809 -> 7    // Gen VII (Alola)
                in 810..905 -> 8    // Gen VIII (Galar)
                in 906..1025 -> 9   // Gen IX (Paldea)
                else -> 0
            }
        }
    }
}