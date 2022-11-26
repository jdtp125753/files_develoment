package com.peliculas.servicio;

import com.peliculas.datos.*;
import com.peliculas.domain.Pelicula;
import com.peliculas.exepciones.*;
public class CatalogoPeliculasImpl implements ICatalogoPeliculas{

	private final IAccesoDatos datos; 

	public CatalogoPeliculasImpl() {
		this.datos = new AccesoDatosImp();
	}
	@Override
	public void agregarPelicula(String nombrePelicula) {
		// TODO Auto-generated method stub
		var pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false; 
		
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar); 
		}catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
		}
	}

	@Override
	public void listarPeliculas() {
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for(var pelicula: peliculas) {
				System.out.println("pelicula: " + pelicula);
			}
		} catch (LecturaDatosEx e) {
			System.out.println("Error de acceso datos");
			e.printStackTrace(System.out);
		}
		
	}

	@Override
	public void buscarPelicula(String buscar) {
		// TODO Auto-generated method stub
		String resultado = null; 
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (AccesoDatosEx e) {
			System.out.println("Error de acceso datos");
			e.printStackTrace(System.out);
		}
		System.out.println("resultado= " +resultado);
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		// TODO Auto-generated method stub
		try {
			if(this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
				
			}
			else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
