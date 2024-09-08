package com.example.practica3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductoViewModel : ViewModel() {

    // Estado del modelo.
    var estado by mutableStateOf(ProductoState())
        private set

    // Inicializar del view model.
    init {
        viewModelScope.launch {

            // Espera 2 segundos.
            delay(2000)

            // Cargar los datos.
            estado = estado.copy(
                productos = listOf(
                    Producto("Coca-Cola 2L", "Coca-Cola 2L Original", 35, "10/02/2016", imagen = R.drawable.coca_cola),
                    Producto("Paleta Payaso", "Chocolate y gomitas", 20, "23/05/2021", imagen = R.drawable.paleta_payaso),
                    Producto("Ruffles", "Ruffles de 185 gramos", 35, "08/07/2012", imagen = R.drawable.ruffles),
                    Producto("Vualá", "Vualá edición \"El Chavo\"", 20, "13/12/2023", imagen = R.drawable.vuala)
                ),
                estaCargando = false
            )
        }
    }
}