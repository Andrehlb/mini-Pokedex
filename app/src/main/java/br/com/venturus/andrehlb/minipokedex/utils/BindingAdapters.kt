package br.com.venturus.andrehlb.minipokedex.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (url.isNullOrEmpty()) return
    view.load(url) {
        crossfade(true)
        placeholder(android.R.colordarker_gray)
    }
}
