package com.gm.peliculas.negocio;

public interface ICatalogoPelicula {
	String NOMBRE_RECURSO = "Peliculas.txt"; 
	
	void agregarPelicula(String nombrePelicula);
	void listarPeliculas();
	void buscarPelicula(String buscar);
	void iniciarCatalogoPeliculas();
}
