package com.gm.peliculas.presentacion;

import java.util.*;

import com.gm.peliculas.negocio.*;

public class Presentacion {
	public static void main(String[] args) {
		int option = -1; 
		
		Scanner sca = new Scanner(System.in);
		
		ICatalogoPelicula catalogo = new CatalogoPeliculaImp(); 
		
		while (option !=0) {
			System.out.println("Elije una opcion \n"
					+ "1. Iniciar catalogo de peliculas\n"
					+ "2. Agregar Pelicula \n"
					+ "3. Listar Peliculas \n"
					+ "4. Buscar Peliculas \n"
					+ "0. Salir");
			
			option = Integer.parseInt(sca.nextLine());
			
			switch(option) {
			case 1: 
				catalogo.iniciarCatalogoPeliculas();
				break; 
			case 2: 
				System.out.println("Digita el nombre de la pelicula: ");
				String nombrePelicula = sca.nextLine();
				catalogo.agregarPelicula(nombrePelicula);
				break;
			case 3:
				catalogo.listarPeliculas();
				break; 
			case 4: 
				System.out.println("Introduce la pelicula a buscar");
				String buscar = sca.nextLine();
				catalogo.buscarPelicula(buscar);
				break; 
			case 0: 
				System.out.println("!!hasta Pronto¡¡");
				break; 
			default: 
				System.out.println("Opcion no valida");
				break; 
			}
		}
		
	}
}
