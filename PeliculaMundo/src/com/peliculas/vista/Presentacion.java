package com.peliculas.vista; //Este paquete tambien se le puede nombrar como "presentación"

import java.util.*;

import com.peliculas.servicio.*;

public class Presentacion {
	public static void main(String[] args) {
		var opcion = -1; 
		var scanner = new Scanner(System.in);
		
		//aqui no hay que interactuar con el paquete de datos ya que de esto se encargo paquete de servico y sus clases
		ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();//aqui se utiliza alto acoplamiento y baja coheción
				
		while(opcion != 0) {
			System.out.println("Elige una opcion: \n"
					+ "1.Iniciar catalogo de peliculas \n"
					+ "2.Agregar Pelicula \n"
					+ "3.Listar peliculas \n"
					+ "4.Buscar pelicula \n"
					+ "0.Salir");
			opcion = Integer.parseInt(scanner.nextLine());
			
			switch(opcion) {
			case 1: 
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2: 
				System.out.println("Introduce el nombre de la pelicula");
				var nombrePelicula = scanner.nextLine();
				catalogo.agregarPelicula(nombrePelicula);
				break;
			case 3: 
				catalogo.listarPeliculas();
				break;
			case 4: 
				System.out.println("Introduce la pelicula a buscar");
				var buscars = scanner.nextLine();
				catalogo.buscarPelicula(buscars);
				break;
			case 0: 
				System.out.println("Hasta pronto");
				break;
			default: 
				System.out.println("Opcion no valida");
				break; 
			}
		}
	}
}
