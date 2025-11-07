package br.com.venturus.andrehlb.minipokedex

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityDetailBinding
import br.com.venturus.andrehlb.minipokedex.model.Pokemon

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera Pokemon passado pela Intent (compatível com API 33+)
        val pokemon: Pokemon? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("pokemon", Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("pokemon")
        }

        // Se existir, popula a UI simples (se seu layout tiver esses ids)
        pokemon?.let {
            binding.pokemonName.text = it.name
            binding.pokemonDetails.text = "ID: ${it.id}"
        }
    }
}
