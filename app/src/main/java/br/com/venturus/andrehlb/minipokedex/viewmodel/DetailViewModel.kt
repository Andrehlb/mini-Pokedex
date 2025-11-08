package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import br.com.venturus.andrehlb.minipokedex.model.PokemonDetailResponse
import br.com.venturus.andrehlb.minipokedex.network.RetrofitClient
import kotlinx.coroutines.launch

/**
 * ViewModel for Pokemon detail screen.
 * Fetches complete Pokemon data from the API including stats, height, and weight.
 */

class DetailViewModel : ViewModel() {

    private val _pokemonDetail = MutableLiveData<PokemonDetailResponse?>()
    val pokemonDetail: LiveData<PokemonDetailResponse?> = _pokemonDetail

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    /**
     * Fetch detailed Pokemon information from the API
     */
    fun fetchPokemonDetails(pokemonId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            try {
                val response = RetrofitClient.api.getPokemonById(pokemonId)
                _pokemonDetail.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao carregar detalhes: ${e.message}"
                _pokemonDetail.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }
}