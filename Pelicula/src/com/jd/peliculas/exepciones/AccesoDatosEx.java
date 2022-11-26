package com.jd.peliculas.exepciones;

import java.io.*;
public class AccesoDatosEx extends EOFException { //Apesar de que extiende de un Exception, esta clase AccesoDatosEx se combierte en padre
	
	public AccesoDatosEx(String mensaje) {
		super(mensaje);
	}
	
}
