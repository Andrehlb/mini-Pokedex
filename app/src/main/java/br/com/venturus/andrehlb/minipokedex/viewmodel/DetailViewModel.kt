package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.venturus.andrehlb.minipokedex.model.PokemonDetailResponse
import androidx.lifecycle.viewModelScope
import br.com.venturus.andrehlb.minipokedex.network.RetrofitClient
import kotlinx.coroutines.launch

/**
 * ViewModel de detalhe simplificado — seguindo o fluxo da aula:
 * - NÃO realiza chamadas de rede aqui.
 * - Recebe o Pokemon via Intent (ou via quem invocar).
 * - Expõe isLoading para controlar a Lottie/overlay.
 */

class DetailViewModel : ViewModel() {

    private val _pokemonDetail = MutableLiveData<PokemonDetailResponse?>()
    val pokemonDetail: LiveData<PokemonDetailResponse?> = _pokemonDetail

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    // Chama o fragment
    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

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