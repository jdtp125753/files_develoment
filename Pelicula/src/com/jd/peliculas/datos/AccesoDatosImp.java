package com.jd.peliculas.datos;

import java.io.*;
import java.util.*;
import java.util.List;

import com.jd.peliculas.domain.Pelicula;
import com.jd.peliculas.exepciones.AccesoDatosEx;
import com.jd.peliculas.exepciones.EscrituraDatosEx;
import com.jd.peliculas.exepciones.LecturaDatosEx;

//Esta clase se pone despues de crear la interfase
public class AccesoDatosImp implements IAccesoDatos{

	@Override
	public boolean existe(String nombreRecurso) throws AccesoDatosEx {
		var archivo = new File(nombreRecurso);
		return archivo.exists();
	}

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
		var archivo = new File(nombreRecurso);
		List<Pelicula> peliculas = new ArrayList<>();
		
			try {
				var entrada = new BufferedReader(new FileReader(archivo));
				String linea = null; 
				linea = entrada.readLine(); 
				
				while(linea != null) {
					Pelicula pelicula = new Pelicula(linea);
					peliculas.add(pelicula);//Este es el que agrega el archivo tipo pelicula
					linea = entrada.readLine();
				}
				entrada.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new LecturaDatosEx("Excepcion al listar pelicula: " + e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				throw new LecturaDatosEx("Excepcion al listar peliculas: " + e.getMessage());
			}
			
		return peliculas;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
		var archivo = new File(nombreRecurso);
		
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("Se ha escrito información al archivo" + pelicula);
		} catch (IOException e) {
			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al escribir peliculas: " + e.getMessage());
		}
		
	}

	@Override
	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
		var archivo  = new File(nombreRecurso);
		String resultado = null; 
		
		try {

			var entrada = new BufferedReader(new FileReader(archivo));
			String linea = null; 
			linea = entrada.readLine();
			int indice = 1; 
			
			while(linea != null) {
				if(buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula " + linea + " Encontrada en el indice: " + indice; 
					break; 
				}
				linea  = entrada.readLine(); 
				indice ++; 
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar peliculas: " + e.getMessage());

		} catch (IOException e) {

			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar peliculas: " + e.getMessage());

		} 

		return resultado;

	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {
		var archivo  = new File(nombreRecurso);		
			
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se a creado el archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AccesoDatosEx("Excepcion al crear el archivo " + e.getMessage());
		}
		
		
	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {
		var archivo  = new File(nombreRecurso);
		if (archivo.exists()) {
			archivo.delete();
			System.out.println("Se ha borrado el archivo");
		}
		
	}

}
