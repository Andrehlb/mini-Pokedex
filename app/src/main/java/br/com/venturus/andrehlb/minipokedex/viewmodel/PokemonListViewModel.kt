package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import br.com.venturus.andrehlb.minipokedex.network.RetrofitClient
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    private val _pokemonListLiveData = MutableLiveData<List<Pokemon>>()
    val pokemonListLiveData: LiveData<List<Pokemon>> = _pokemonListLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        loadPokemonFromApi()
    }

    private fun loadPokemonFromApi() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                // Buscar lista básica de Pokemon - 1025 (gen e I a IX)
                val response = RetrofitClient.pokeApiService.getPokemonList(1025)
                val pokemonList = mutableListOf<Pokemon>()

                // Busca detalhes de cada Pokemon para obter tipos
                response.results.forEach { result ->
                    try {
                        val id = result.url.split("/").dropLast(1).last().toInt()
                        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

                        // Buscar detalhes para obter tipos
                        val details = RetrofitClient.pokeApiService.getPokemonById(id)
                        val types = details.types.map { it.type.name.capitalize() }
                        val generation = Pokemon.getGenerationFromId(id)

                        pokemonList.add(
                            Pokemon(
                                id = id,
                                name = result.name.replaceFirstChar { it.uppercase() },
                                imageUrl = imageUrl,
                                types = types,
                                generation = generation
                            )
                        )
                    } catch (e: Exception) {
                        // Se falhar para um Pokemon específico, continua com os outros
                        e.printStackTrace()
                    }
                }

                _pokemonListLiveData.value = pokemonList
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Sem internet ou erro na sincronização: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Extensão auxiliar para capitalizar strings
    private fun String.capitalize(): String {
        return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}