package br.com.venturus.andrehlb.minipokedex.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import br.com.venturus.andrehlb.minipokedex.R
import android.widget.TextView
import br.com.venturus.andrehlb.minipokedex.model.PokemonDetailResponse

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        view.setImageResource(R.drawable.ic_pokemon_placeholder)
        return
    }
    view.load(url) {
        crossfade(true)
        placeholder(R.drawable.ic_pokemon_placeholder)
        error(R.drawable.ic_error)
    }
}

@BindingAdapter("pokemonTypes")
fun setPokemonTypes(view: TextView, pokemonDetail: PokemonDetailResponse?) {
    pokemonDetail?.let {
        val types = it.types.joinToString(", ") { type ->
            type.type.name.replaceFirstChar { char ->
                if (char.isLowerCase()) char.titlecase() else char.toString()
            }
        }
        view.text = types
    }
}

@BindingAdapter("pokemonHeight")
fun setPokemonHeight(view: TextView, height: Int?) {
    height?.let {
        val heightInMeters = it / 10.0
        view.text = String.format("%.1f m", heightInMeters)
    }
}

@BindingAdapter("pokemonWeight")
fun setPokemonWeight(view: TextView, weight: Int?) {
    weight?.let {
        val weightInKg = it / 10.0
        view.text = String.format("%.1f kg", weightInKg)
    }
}

@BindingAdapter("pokemonStat")
fun setPokemonStat(view: TextView, pokemonDetail: PokemonDetailResponse?) {
    val statName = view.tag as? String ?: return
    pokemonDetail?.let {
        val stat = it.stats.find { statItem ->
            statItem.stat.name == statName
        }
        view.text = stat?.baseStat?.toString() ?: "0"
    }
}