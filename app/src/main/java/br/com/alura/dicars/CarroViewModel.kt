package br.com.alura.dicars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import br.com.alura.dicars.database.DicarsDatabase
import br.com.alura.dicars.repository.CarroRepository
import br.com.alura.dicars.webclient.CarroWebClient
import br.com.alura.dicars.webclient.RetrofitInit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CarroViewModel(private val repositorio: CarroRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(ListaCarrosUitState())
    val uiState: StateFlow<ListaCarrosUitState>
        get() = _uiState.asStateFlow()

    init {
        carregaCarros()
    }

    fun carregaCarros() {
        viewModelScope.launch {
            val carros = repositorio.buscaTodos()
            _uiState.value = _uiState.value.copy(
                carros = carros
            )
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val context =
                    checkNotNull(this[APPLICATION_KEY] as DicarsApplication).applicationContext
                val repositorio = CarroRepository(
                    DicarsDatabase.getDatabase(context).CarroDao(),
                    CarroWebClient(RetrofitInit().carroService)
                )
                CarroViewModel(repositorio)
            }
        }
    }
}
