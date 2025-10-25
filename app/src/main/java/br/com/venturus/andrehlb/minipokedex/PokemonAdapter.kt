package br.com.venturus.andrehlb.minipokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.venturus.andrehlb.minipokedex.databinding.ItemPokemonBinding

data class Pokemon(val id: Int, val name: String)

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(DiffCallback) {

    class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.pokemonName.text = pokemon.name
            // serão adicionados mais bindings aqui futuramente
        }
    }

}