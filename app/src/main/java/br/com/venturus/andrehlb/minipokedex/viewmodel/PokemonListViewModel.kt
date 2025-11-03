package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import br.com.venturus.andrehlb.minipokedex.network.RetrofitClient
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    // LiveData para lista Pokémon
    val pokemonListLiveData = MutableLiveData<List<Pokemon>>()

    // Live Data para carregar o loading (ProgressBar)
    val isLoadingLiveData = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun getPokemonList() {
          viewModelScope.launch {
                 // Mostra o loading
                 isLoading.value = true
                 try {
                     val response = RetrofitClient.pokemonService.getPokemonList()
                     val pokemons = response.results.mapIndexed ( index, result ->
                         val id = result.url
                             .removeSuffix("/")
                             .substringAfterLast("/")
                             .toInt()
                         val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
                         Pokemon(id, result.name capitalize()), imageUrl)
                     }
                     pokemonList.value = pokemons
                 } catch (e: Exception) {
                     errorMessage.value = "Erro ao buscar Pokémon: ${e.message}"
                 } finally {
            // Esconde o loading
            isLoading.value = false
        }
    }
}