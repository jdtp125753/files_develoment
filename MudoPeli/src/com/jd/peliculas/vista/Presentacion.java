package com.jd.peliculas.vista;

import java.util.Scanner;

import com.jd.peliculas.servicio.*;

public class Presentacion {
	public static void main(String[] args) {
		int opcion = -1; 
		var scanner = new Scanner(System.in);
		
		ICatalogoPeliculas catalogo = new CatalogoPeliculasImp();
		
		while(opcion !=0) {
			System.out.println("Elige una opcion: \n"
					+ "1.Iniciar catalogo Peliculas \n"
					+ "2.Agregar Pelicula \n"
					+ "3.Listar Peliculas \n"
					+ "4.Buscar Peliculas \n"
					+ "0.Salir");
			
			opcion = Integer.parseInt(scanner.nextLine()); 
			
			switch(opcion) {
			case 1: 
				catalogo.iniciarCatalogoPelicula();
				break; 
			case 2: 
				System.out.println("Introduce el nombre de la pelicula: ");
				var nombrePelicula = scanner.nextLine();
				catalogo.agregarPelicula(nombrePelicula);
				break; 
			case 3: 
				catalogo.listarPeliculas();
				System.out.println("\n");
				break; 
			case 4: 
				System.out.println("Introduce una pelicula a buscar");
				var buscar = scanner.nextLine();
				catalogo.buscarPelicula(buscar);
				break; 
			case 0: 
				System.out.println("Hasta Pronto!");
				break;
			default: 
				System.out.println("Opcion no reconocida");
				break; 
			}
		}
	}
}
