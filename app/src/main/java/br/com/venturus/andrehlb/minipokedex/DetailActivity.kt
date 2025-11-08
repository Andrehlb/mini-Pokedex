package br.com.venturus.andrehlb.minipokedex

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityDetailBinding
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.viewModel = viewModel

        // Recupera Pokemon passado pela Intent
        val pokemon: Pokemon? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("pokemon", Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("pokemon")
        }

        // Buscar dados detalhados da API
        pokemon?.let {
            viewModel.fetchPokemonDetails(it.id)
        }

        // Observer para os detalhes do Pokemon
        viewModel.pokemonDetail.observe(this) { pokemonDetail ->
            pokemonDetail?.let {
                binding.pokemonDetail = it
                binding.executePendingBindings()
            }
        }

        // Observer para estado de loading
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        // Observer para mensagens de erro
        viewModel.errorMessage.observe(this) { message ->
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}