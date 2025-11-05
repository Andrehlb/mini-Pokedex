package br.com.venturus.andrehlb.minipokedex.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.venturus.andrehlb.minipokedex.model.Pokemon

class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}