package pl.akademiaandroida.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    fun getCharacters(): Call<CharactersResponse>
}