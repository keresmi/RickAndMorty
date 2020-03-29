package pl.akademiaandroida.rickandmorty.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.akademiaandroida.rickandmorty.di.appModule
import pl.akademiaandroida.rickandmorty.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, appModule))
        }
    }
}