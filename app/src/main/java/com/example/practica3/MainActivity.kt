package com.example.practica3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.practica3.ui.theme.Practica3Theme

class MainActivity : ComponentActivity() {

    // Método que es llamado al crear la activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancia del viewModel.
        val viewModel: ProductoViewModel = ProductoViewModel()

        // Establecer el contenido de la aplicación.
        setContent {
            Practica3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaProductos(viewModel, modifier = Modifier.padding(innerPadding))
//                    FormularioProductos(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}