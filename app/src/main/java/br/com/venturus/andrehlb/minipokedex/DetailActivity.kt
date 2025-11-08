package br.com.venturus.andrehlb.minipokedex

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityDetailBinding
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import br.com.venturus.andrehlb.minipokedex.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.viewModel = viewModel

        // Recupera Pokemon passado pela Intent (compatível com API 33+)
        val pokemon: Pokemon? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("pokemon", Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("pokemon")
        }

        // Fetch detailed data from API
        pokemon?.let {
            viewModel.fetchPokemonDetails(it.id)
        }

        // Observe Pokemon details
        viewModel.pokemonDetail.observe(this) { pokemonDetail ->
            pokemonDetail?.let {
                binding.pokemonDetail = it
                binding.executePendingBindings()
            }
        }

        // Observe loading state
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        // Observe error messages
        viewModel.errorMessage.observe(this) { message ->
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}
