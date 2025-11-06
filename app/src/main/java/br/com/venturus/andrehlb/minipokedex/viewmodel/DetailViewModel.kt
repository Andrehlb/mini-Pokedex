package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import br.com.venturus.andrehlb.minipokedex.network.RetrofitClient
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _pokemonDetail = MutableLiveData<Pokemon?>()
    val pokemonDetail: LiveData<Pokemon?> = _pokemonDetail

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    /**
     * Busca o detalhe do Pokémon por nome.
     * - Mantém _isLoading true durante a operação.
     * - Preenche _pokemonDetail com o resultado ou seta _errorMessage.
     */
    fun loadPokemonDetail(name: String) {
        // Normalize (em caso de entrada com uppercase/minúsculas)
        val searchName = name.trim().lowercase()
        _isLoading.value = true
        _errorMessage.value = null

        viewModelScope.launch {
            try {
                // A PokeAPI original busca por nome /pokemon/{name}
                val response = RetrofitClient.pokeApiService.getPokemonByName(searchName)
                // Monta o model local (ajuste se seu Pokemon exigiu campos diferentes)
                val pokemon = Pokemon(
                    id = response.results[0].url.split("/").dropLast(1).last().toInt(),
                    name = response.results[0].name.replaceFirstChar { it.uppercase() },
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${response.results[0].url.split("/").dropLast(1).last()}.png"
                )
                _pokemonDetail.value = pokemon
                _errorMessage.value = null
            } catch (e: Exception) {
                _pokemonDetail.value = null
                _errorMessage.value = "Sem internet ou Pokémon não encontrado: ${e.message ?: "erro"}"
            } finally {
                _isLoading.value = false
            } // try/catch/finally
        } // viewModelScope.launch
    } // loadPokemonDetail
} // DetailViewModel
