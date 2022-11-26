package com.jd.peliculas.datos;

import java.util.*; 
import com.jd.peliculas.datos.*;
import com.jd.peliculas.domain.Pelicula;
import com.jd.peliculas.exepciones.*;

//esta clase se hace despues de la calse de dominio de pelicula
public interface IAccesoDatos {
	
	boolean existe (String nombreRecurso) throws AccesoDatosEx; 
	
	List <Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
	
	void escribir (Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx; 
	
	String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx; 
	
	void crear (String nombreRecurso) throws AccesoDatosEx; 
	
	void borrar(String nombreRecurso) throws AccesoDatosEx; 
	
}
