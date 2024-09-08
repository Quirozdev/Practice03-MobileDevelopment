package com.example.practica3


data class ProductoState(
    val productos: List<Producto> = listOf(),
    val estaCargando: Boolean = true
)
