package br.com.venturus.andrehlb.minipokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.venturus.andrehlb.minipokedex.model.Pokemon

/**
 * ViewModel de detalhe simplificado — seguindo o fluxo da aula:
 * - NÃO realiza chamadas de rede aqui.
 * - Recebe o Pokemon via Intent (ou via quem invocar).
 * - Expõe isLoading para controlar a Lottie/overlay.
 */

class DetailViewModel : ViewModel() {

    private val _pokemonDetail = MutableLiveData<Pokemon?>()
    val pokemonDetail: LiveData<Pokemon?> = _pokemonDetail

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    /**
     * Configura o Pokemon (por exemplo, chamado pelo Activity ao receber a Intent).
     * Mantemos padrão null para sinalizar ausência.
     */
    fun setPokemon(pokemon: Pokemon?) {
        _pokemonDetail.value = pokemon
    }

    /**
     * Controladores de loading — usados para mostrar/esconder o overlay + Lottie.
     */
    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }                           

    /**
     * `Definir mensagem de erro (opcional).
     */
    fun setError(message: String?) {
        _errorMessage.value = message
    }
}