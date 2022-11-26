package com.jd.peliculas.servicio;

public interface ICatalogoPeliculas {
	
	String NOMBRE_RECURSO = "Peliculas.txt";
	
	void agregarPelicula(String nombrePelicula);
	
	void listarPeliculas();
	
	void buscarPelicula(String buscar);
	
	void iniciarCatalogoPelicula();
}
