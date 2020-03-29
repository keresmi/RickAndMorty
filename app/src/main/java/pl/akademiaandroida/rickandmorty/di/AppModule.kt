package pl.akademiaandroida.rickandmorty.di

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.akademiaandroida.rickandmorty.data.Repository
import pl.akademiaandroida.rickandmorty.domain.GetCharactersUseCase
import pl.akademiaandroida.rickandmorty.presentation.CharacterAdapter
import pl.akademiaandroida.rickandmorty.presentation.MainViewModel

val appModule = module {
    factory { Repository(get()) }
    factory { GetCharactersUseCase(get()) }

    factory { CharacterAdapter() }
    factory<RecyclerView.LayoutManager> { GridLayoutManager(androidContext(), 2) }

    viewModel { MainViewModel(get()) }
}