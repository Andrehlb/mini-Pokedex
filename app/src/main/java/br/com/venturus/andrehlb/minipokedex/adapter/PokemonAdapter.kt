package br.com.venturus.andrehlb.minipokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.venturus.andrehlb.minipokedex.databinding.ItemPokemonBinding
import br.com.venturus.andrehlb.minipokedex.model.Pokemon

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(PokemonDiffCallback()) {

    class PokemonViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position) // ← CORRETO
        holder.binding.pokemon = pokemon
        holder.binding.executePendingBindings()
    }
}