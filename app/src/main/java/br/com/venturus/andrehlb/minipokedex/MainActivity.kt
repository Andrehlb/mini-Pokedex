package br.com.venturus.andrehlb.minipokedex

import android.content.Intent  // ← ADICIONE: Import para navegação
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityMainBinding
import br.com.venturus.andrehlb.minipokedex.viewmodel.PokemonListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonListViewModel
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[PokemonListViewModel::class.java]
        binding.viewModel = viewModel

        // MODIFICADO: Adapter agora recebe callback de clique
        val adapter = PokemonAdapter { pokemon ->
            // Navegar para DetailActivity ao clicar
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("pokemon", pokemon)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.pokemonListLiveData.observe(this) { pokemonList ->
            adapter.submitList(pokemonList)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.lottieLoading.visibility = View.VISIBLE
                binding.lottieLoading.playAnimation()
            } else {
                binding.lottieLoading.pauseAnimation()
                binding.lottieLoading.visibility = View.GONE
            }
        }

        viewModel.errorMessage.observe(this) { message ->
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }

        Log.d(tag, "onCreate chamado")

        binding.searchEditText.requestFocus()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            Log.d(tag, "Padding aplicado")
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    override fun onStart() { super.onStart(); Log.d(tag, "onStart chamado") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume chamado") }
    override fun onPause() { super.onPause(); Log.d(tag, "onPause chamado") }
    override fun onStop() { super.onStop(); Log.d(tag, "onStop chamado") }
    override fun onDestroy() { super.onDestroy(); Log.d(tag, "onDestroy chamado") }
    override fun onRestart() { super.onRestart(); Log.d(tag, "onRestart chamado") }
}