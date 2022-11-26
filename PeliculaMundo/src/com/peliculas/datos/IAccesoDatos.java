package com.peliculas.datos;
import com.peliculas.exepciones.*;
import com.peliculas.domain.*;
import java.util.*;
public interface IAccesoDatos {
	boolean existe(String nombreArchivo) throws AccesoDatosEx;
	
	List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
	
	void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
	
	String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx; 
	
	void crear (String nombreRecurso) throws AccesoDatosEx; 
	
	void borrar(String nombreRecurso) throws AccesoDatosEx;
}
