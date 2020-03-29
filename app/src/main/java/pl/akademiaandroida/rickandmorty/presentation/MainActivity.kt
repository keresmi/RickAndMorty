package pl.akademiaandroida.rickandmorty.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import pl.akademiaandroida.rickandmorty.Character
import pl.akademiaandroida.rickandmorty.R

class MainActivity : AppCompatActivity() {

    private val adapter: CharacterAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        viewModel.onViewCreated()
        observeData()
        observeError()
    }

    private fun observeError() {
        viewModel.error.observe(this) { throwable ->
            throwable.message
                ?.let { showErrorMessage(it) }
        }
    }

    private fun observeData() {
        viewModel.characters.observe(this) { showCharacters(it) }
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(
            this,
            "An error occurred, code: $message}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showCharacters(characters: List<Character>) {
        adapter.setCharacters(characters)
    }
}
