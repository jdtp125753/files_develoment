package com.gm.peliculas.negocio;

import java.util.List; 

import com.jd.peliculas.datos.*;
import com.jd.peliculas.domain.*;
import com.jd.peliculas.exepciones.*;
public class CatalogoPeliculaImp implements ICatalogoPelicula{
	 private final IAccesoDatos datos; 
	 
	 public CatalogoPeliculaImp() {
		 this.datos = new AccesoDatosImp();
	 }
	 
	 public void agregarPelicula(String nombrePelicula) {
		 Pelicula pelicula = new Pelicula(nombrePelicula);
		 
		 boolean anexar = false; 
		 
		try {
			 anexar = datos.existe(NOMBRE_RECURSO);
			 datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
	
		}
		catch(AccesoDatosEx e) {
			e.printStackTrace();
			System.out.println("Error de acceso datos: " + e.getMessage());
		}
	 }

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
			for(Pelicula pelicula : peliculas) {
				System.out.println("Pelicula: " + pelicula);
			}
		} catch (LecturaDatosEx e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}
		
	}

	@Override
	public void buscarPelicula(String buscar) {
		String resultado = null; 
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
			
		} catch (LecturaDatosEx e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		
		}
		
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		try {
			if (this.datos.existe(NOMBRE_RECURSO)){
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			}else {
				datos.crear(NOMBRE_RECURSO);
			}
		}catch(AccesoDatosEx e) {
			e.printStackTrace(System.out);
		}
		
	}
}