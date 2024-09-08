package com.example.practica3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListaProductos(viewModel: ProductoViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.icono_producto), contentDescription = "Icono de producto", modifier = Modifier.size(80.dp))
            // Titulo.
            Text(
                text = "Productos",
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(id = R.color.azul_muy_oscuro),
                fontWeight = FontWeight.Bold
            )
        }

        // Estado del viewModel.
        val estado = viewModel.estado

        // Carga.
        if (estado.estaCargando) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            // Mostrar los productos.
            LazyColumn(modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {

                // Definición de los registros.
                items(estado.productos) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier
                            .border(
                                shape = RoundedCornerShape(16.dp),
                                width = 2.dp,
                                color = colorResource(id = R.color.azul_oscuro_ligero)
                            )
                            .padding(24.dp)
                            .fillParentMaxWidth()
                    ) {
                        Image(painter = painterResource(id = it.imagen), contentDescription = "Icono Producto", modifier = Modifier
                            .size(120.dp))
                        Column {
                            Text(
                                text = it.nombre,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.amarilloso)
                            )
                            Text(text = "Fecha registro: " + it.fecha,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.ExtraLight,
                                color = colorResource(id = R.color.azul_oscuro_ligero)
                            )
                            Text(text = it.descripcion,
                                color = colorResource(id = R.color.azul_muy_oscuro))
                            Text(text = "$" + it.precio.toString(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.azul_medio_oscuro))
                        }
                    }
                }
            }
        }
    }
}
