package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.venturus.andrehlb.minipokedex.model.Pokemon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    // LiveData para lista Pokémon
    val pokemonListLiveData = MutableLiveData<List<Pokemon>>()

    // Live Data para carregar o loading (ProgressBar)
    val isLoadingLiveData = MutableLiveData<Boolean>()

    /*
     * Simulação de uma chamada de rede com delay de 2 segundos
     * e insere na lista com dados fake
     * /
0    fun getPokemonList() {
        viewModelScope.launch {
            // 1. Mostra o loading
            isLoading.value = true

            // 2. Simula o delay da API
            delay(2000)

            // 3. Cria a lista fake
            val fakeList = listOf(
                Pokemon(1, "Bulbasaur"),
                Pokemon(2, "Charmander"),
                Pokemon(3, "Squirtle")
                // Adicione mais Pokémon aqui
            )

            // 4. Atualiza o LiveData (UI observa e reage)
            pokemonList.value = fakeList

            // 5. Esconde o loading
            isLoading.value = false
        }
    }
}