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
                val response = RetrofitClient.pokeApiService.getPokemonList(20)
                val pokemonList = response.results.map { result ->
                    val id = result.url.split("/").dropLast(1).last().toInt()
                    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
                    Pokemon(id, result.name.replaceFirstChar { it.uppercase() }, imageUrl)
                }
                _pokemonListLiveData.value = pokemonList
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Erro: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}