package br.com.venturus.andrehlb.minipokedex.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import android.R

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
        transformations(CircleCropTransformation())
    }
}