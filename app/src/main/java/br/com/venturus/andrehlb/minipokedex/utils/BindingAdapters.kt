package br.com.venturus.andrehlb.minipokedex.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import br.com.venturus.andrehlb.minipokedex.R

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let {
        imageView.load(it) {
            placeholder(R.drawable.placeholder_image) // Imagem a ser mostrada durante o carregamento
            error(R.drawable.error_image) // Imagem a ser mostrada em caso de erro
        }
    }
}
