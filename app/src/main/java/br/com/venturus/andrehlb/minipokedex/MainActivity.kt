package br.com.venturus.andrehlb.minipokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import android.recyclerview.widgrt.LinearLayoutManager
import br.com.venturusandrehlb.minipokedex.adapter.PokemonAdapter
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityMainBinding
import br.com.venturus.andrehlb.minipokedex.viewmodel.PokemonListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonListViewModel
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        // Installs the splash screen. This must be called before super.onCreate()
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // Data Biding
        // Conecta o ciclo de vida da Activity para que o LiveData na UI seja usado de forma automática.
        binding.lifecycleOwner = this
        // Instanciação do ViewModel
        viewModel = ViewModelProvider(this)[PokemonListViewModel::class.java]
        // Conexão da ViewModel com a variável <data> no XML.
        binding.viewModel = viewModel

        val adapter = PokemonAdapter()
        binding.pokemonRecyclerView.adapter = adapter

        viewModel.pokemonList.observe(this) { pokemonList ->
            adapter.submitList(pokemonList) // Atualiza a lista do adaptador quando os dados mudam
        }

        Log.d(tag, "onCreate chamado")
        binding.searchEditText.requestFocus()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            Log.d(tag, "Padding aplicado")
            v.setPadding(
                systemBars.left,
                systemBars.top * 2,
                systemBars.right,
                systemBars.bottom * 2
            )
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart chamado")
    }
}