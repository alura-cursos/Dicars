package br.com.alura.dicars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.dicars.repository.CarroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarroViewModel @Inject constructor(private val repositorio: CarroRepository) : ViewModel() {
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
}
