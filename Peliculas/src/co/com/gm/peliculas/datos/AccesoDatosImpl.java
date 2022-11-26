package co.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;

import co.com.gm.peliculas.domain.Pelicula;
import co.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

	@Override
	public boolean existe(String nombreRecurso) throws AccesoDatosEx {
		var archivo = new File(nombreRecurso);
		return archivo.exists(); 
	}

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
		var archivo = new File(nombreRecurso);
		List<Pelicula> peliculas = new ArrayList <>();
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null; 
			linea  = entrada.readLine(); 
			
			while ( linea !=null) {
				var pelicula = new Pelicula(linea);
				peliculas.add(pelicula); 
				linea = entrada.readLine(); 
			}
			entrada.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al listar Peliculas: " +  e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas; 
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
		var archivo = new File(nombreRecurso); 
		try {
			var salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString()); 
			salida.close(); 
			System.out.println("Se escribio información al archivo "); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al escribir: " + e.getCause()); 
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
			
			int indice = 1; 
			while ( linea != null) {
				if(buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula: " + linea + "encontraada en el indice: " + indice;
					break; 
				}
				linea = entrada.readLine(); 
				indice ++; 
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			throw new LecturaDatosEx("Excepcion al buscar Peliculas: " +  e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {
		var archivo = new File (nombreRecurso); 
		try {
			var salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo "); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
			throw new AccesoDatosEx("Excepcion al crear Peliculas: " +  e.getMessage());
		} 
		
		
	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {
		// TODO Auto-generated method stub
		var archivo = new File(nombreRecurso); 
		if(archivo.exists()) {
			archivo.delete(); 
			System.out.println("Se  ha borrado el archivo"); 
		}
		
	}

}
