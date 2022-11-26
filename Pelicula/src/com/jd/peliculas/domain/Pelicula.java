package com.jd.peliculas.domain;

import java.io.*;
//Esta clase se hace despues de hacer las exepciones
public class Pelicula implements Serializable{
	private static final long serialVersionUID=1L;
	private String name; 
	
	public Pelicula() {
		
	}
	
	public Pelicula(String name) {
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return "name=" + name;
	
	}
	
	
}
