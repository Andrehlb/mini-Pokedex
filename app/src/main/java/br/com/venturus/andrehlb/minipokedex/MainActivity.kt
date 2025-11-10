package br.com.venturus.andrehlb.minipokedex

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.venturus.andrehlb.minipokedex.databinding.ActivityMainBinding
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import br.com.venturus.andrehlb.minipokedex.viewmodel.PokemonListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonListViewModel
    private val tag = "MainActivity"

    // Lista completa de Pokemon (cache para filtros)
    private var fullPokemonList: List<Pokemon> = emptyList()

    // Variáveis para armazenar os Filtros selecionados
    private var selectedType: String? = null
    private var selectedGeneration: Int? = null

    // Mensagens de loading periódicas
    private val loadingMessages = listOf(
        "Chill, os Pokémon tão chegando! Aguarda aí.",
        "Fica de olho, os Pokémon estão a caminho! Só mais um secinho.",
        "Pokémon inbound! Relaxa que já vem.",
        "Hold on, os Pokémon estão carregando! Não vai embora ainda.",
        "Os Pokémon tão quase lá! Fica mais um pouquinho."
    )
    private var messageIndex = 0
    private val handler = Handler(Looper.getMainLooper())
    private val updateMessageRunnable = object : Runnable {
        override fun run() {
            if (messageIndex < loadingMessages.size) {
                binding.loadingMessageTextView.text = loadingMessages[messageIndex]
                binding.loadingMessageTextView.visibility = View.VISIBLE
                messageIndex++
                handler.postDelayed(this, 7000) // A cada 7 segundos
            } else {
                // Reinicia se acabar as mensagens
                messageIndex = 0
                handler.postDelayed(this, 7000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[PokemonListViewModel::class.java]
        binding.viewModel = viewModel

        // Adapter com callback de clique
        val adapter = PokemonAdapter { pokemon ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("pokemon", pokemon)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar spinners de filtro
        setupTypeFilterSpinner()
        setupGenerationFilterSpinner()

        viewModel.pokemonListLiveData.observe(this) { pokemonList ->
            fullPokemonList = pokemonList
            applyFilters()
        }

        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                binding.lottieLoading.visibility = View.VISIBLE
                binding.lottieLoading.playAnimation()
                // NOVO: Inicia mensagens periódicas
                messageIndex = 0
                handler.post(updateMessageRunnable)
            } else {
                binding.lottieLoading.pauseAnimation()
                binding.lottieLoading.visibility = View.GONE
                // NOVO: Para mensagens e esconde TextView
                handler.removeCallbacks(updateMessageRunnable)
                binding.loadingMessageTextView.visibility = View.GONE
            }
        }

        viewModel.errorMessage.observe(this) { message ->
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }

        Log.d(tag, "onCreate chamado")

        // binding.searchEditText.requestFocus()

        // Busca em tempo real (agora integrada com filtros)
        binding.searchEditText.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: android.text.Editable?) {
                applyFilters()
            }
        })
    }

    // Configurar spinner de tipos
    private fun setupTypeFilterSpinner() {
        val types = listOf(
            "Todos os Tipos", "Normal", "Fire", "Water", "Electric", "Grass",
            "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic",
            "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.typeFilterSpinner.adapter = adapter

        binding.typeFilterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedType = if (position == 0) null else types[position]
                applyFilters()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedType = null
            }
        }
    }

    // Configurar spinner de gerações
    private fun setupGenerationFilterSpinner() {
        val generations = listOf(
            "Todas Gerações",
            "Gen I (Kanto) – 1996-1999",
            "Gen II (Johto) – 1999-2002",
            "Gen III (Hoenn) – 2002-2006",
            "Gen IV (Sinnoh) – 2006-2010",
            "Gen V (Unova) – 2010-2013",
            "Gen VI (Kalos) – 2013-2016",
            "Gen VII (Alola) – 2016-2019",
            "Gen VIII (Galar) – 2019-2022",
            "Gen IX (Paldea) – 2022-Hoje"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.generationFilterSpinner.adapter = adapter

        binding.generationFilterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedGeneration = if (position == 0) null else position
                applyFilters()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedGeneration = null
            }
        }
    }

    // Aplicar todos os filtros combinados (busca + tipo + geração)
    private fun applyFilters() {
        val query = binding.searchEditText.text.toString().trim()

        var filteredList = fullPokemonList

        // Filtro por nome (busca)
        if (query.isNotEmpty()) {
            filteredList = filteredList.filter { pokemon ->
                pokemon.name.contains(query, ignoreCase = true)
            }
        }

        // Filtro por tipo
        selectedType?.let { type ->
            filteredList = filteredList.filter { pokemon ->
                pokemon.types.any { it.equals(type, ignoreCase = true) }
            }
        }

        // Filtro por geração
        selectedGeneration?.let { gen ->
            filteredList = filteredList.filter { pokemon ->
                pokemon.generation == gen
            }
        }

        // Atualizar adapter
        (binding.recyclerView.adapter as? PokemonAdapter)?.submitList(filteredList)
    }

    override fun onStart() { super.onStart(); Log.d(tag, "onStart chamado") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume chamado") }
    override fun onPause() { super.onPause(); Log.d(tag, "onPause chamado") }
    override fun onStop() { super.onStop(); Log.d(tag, "onStop chamado") }
    override fun onDestroy() { super.onDestroy(); Log.d(tag, "onDestroy chamado") }
    override fun onRestart() { super.onRestart(); Log.d(tag, "onRestart chamado") }
}