package pl.akademiaandroida.rickandmorty.data

import pl.akademiaandroida.rickandmorty.CharactersResponse
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}