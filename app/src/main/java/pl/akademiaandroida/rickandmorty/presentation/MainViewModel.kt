package pl.akademiaandroida.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pl.akademiaandroida.rickandmorty.Character
import pl.akademiaandroida.rickandmorty.domain.GetCharactersUseCase

class MainViewModel(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    val characters = MutableLiveData<List<Character>>()
    val error = MutableLiveData<Throwable>()

    fun onViewCreated() {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersUseCase(viewModelScope) { result ->
            result.onSuccess { characters.value = it }
            result.onFailure { error.value = it }
        }
    }
}