package pl.akademiaandroida.rickandmorty.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.akademiaandroida.rickandmorty.Character
import pl.akademiaandroida.rickandmorty.data.Repository

class GetCharactersUseCase(private val repository: Repository) {

    operator fun invoke(
        coroutineScope: CoroutineScope,
        onResult: (Result<List<Character>>) -> Unit
    ) {
        coroutineScope.launch {
            val result = withContext(Dispatchers.IO) {
                runCatching { repository.getCharacters() }
            }

            onResult(result)
        }
    }
}