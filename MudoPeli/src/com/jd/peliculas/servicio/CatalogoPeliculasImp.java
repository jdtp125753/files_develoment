package com.jd.peliculas.servicio;

import com.jd.peliculas.datos.*;
import com.jd.peliculas.domain.Pelicula;
import com.jd.peliculas.excepciones.AccesoDatosEx;
import com.jd.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImp implements ICatalogoPeliculas{
	private final IAccesoDatos datos; 
	
	public CatalogoPeliculasImp() {
		this.datos = new AccesoDatosImp();

	}
	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false; 
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx e) {
			System.out.println("Error de acceso a datos");
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void listarPeliculas() {
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for(var pelicula: peliculas) {
				System.out.println("pelicula: " + pelicula );
			}
		} catch (LecturaDatosEx e) {
			System.out.println("Error de acceso datos");
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void buscarPelicula(String buscar) {
		String resultado = null; 
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (LecturaDatosEx e) {
			System.out.println("De acceso Datos");
			e.printStackTrace(System.out);
		}
		
		
	}
	@Override
	public void iniciarCatalogoPelicula() {
		try {
			if(this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			}
			else {
				datos.crear(NOMBRE_RECURSO);
			}
			}
			catch(AccesoDatosEx ex) {
				System.out.println("Error al iniciar catalogo de peliculas");
				ex.printStackTrace(System.out);
			}
		
	}

	
	
}
