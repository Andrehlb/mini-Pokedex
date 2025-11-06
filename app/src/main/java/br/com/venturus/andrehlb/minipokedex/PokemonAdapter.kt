package br.com.venturus.andrehlb.minipokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.venturus.andrehlb.minipokedex.databinding.ItemPokemonBinding
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import androidx.recyclerview.widget.ListAdapter
class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(DiffCallback) {

    class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon?) {
            binding.pokemon = pokemon  // ← AGORA É model.Pokemon
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean = oldItem == newItem
        }
    }
}
