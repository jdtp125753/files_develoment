package com.jd.peliculas.datos;

import java.io.*;
import java.util.*;

import com.jd.peliculas.domain.Pelicula;
import com.jd.peliculas.excepciones.*;

public class AccesoDatosImp implements IAccesoDatos{

	@Override
	public boolean existe(String nombreRecurso)  {
			
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
			while (linea != null) {
				var pelicula = new Pelicula(linea);
				peliculas.add(pelicula);
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al Listar Peliculas: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al Listar Peliculas: " + e.getMessage());
		}
		
		return peliculas;
	
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
		var archivo = new File(nombreRecurso);
		try {
			var salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.print(pelicula.toString());
			salida.close();
			System.out.println("Se a escrito información al archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al Escribir Peliculas: " + e.getMessage());
		}
		
		
	}

	@Override
	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
		var archivo = new File(nombreRecurso);
		String resultado = null;
		
		try {
			var entrada = new BufferedReader(new FileReader(archivo));
			String linea = null; 
			linea = entrada.readLine();
			var indice = 1; 
			while(linea != null) {
				if(buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula " + linea + " Encontrada en el indice " + indice; 
					break;
				}
				linea = entrada.readLine();
				indice++; 
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar Peliculas: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar Peliculas: " + e.getMessage());
		}
		return resultado ; 
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {
		var archivo = new File(nombreRecurso);
		try {
			var salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AccesoDatosEx("Excepcion al crear Peliculas: " + e.getMessage());
		}
	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {
		var archivo = new File(nombreRecurso);

		if(archivo.exists())archivo.delete(); 

		System.out.println("Se ha borrado el archivo");

	}
	
		
		


}
