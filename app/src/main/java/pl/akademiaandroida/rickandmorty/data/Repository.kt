package pl.akademiaandroida.rickandmorty.data

import pl.akademiaandroida.rickandmorty.Character

class Repository(private val api: RickAndMortyAPI) {

    suspend fun getCharacters(): List<Character> {
        return api.getCharacters().results
    }
}