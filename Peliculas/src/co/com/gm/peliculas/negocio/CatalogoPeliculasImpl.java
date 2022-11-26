package co.com.gm.peliculas.negocio;

import co.com.gm.peliculas.datos.AccesoDatosImpl;
import co.com.gm.peliculas.datos.IAccesoDatos;
import co.com.gm.peliculas.domain.Pelicula;
import co.com.gm.peliculas.excepciones.AccesoDatosEx;
import co.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
	private final IAccesoDatos datos; 
	
	
	public CatalogoPeliculasImpl() {
		this.datos = new AccesoDatosImpl();
		
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula); 
		boolean anexar = false; 
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void listarPeliculas() {
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for(var pelicula : peliculas) {
				System.out.println("pelicula: "+ pelicula);
			}
		} catch (LecturaDatosEx e) {
			// TODO Auto-generated catch block
		
			System.out.println("Error de acceso datos");
			e.printStackTrace(System.out);	
		}
		
	}

	@Override
	public void buscarPelicula(String buscar) {
		String resultado = null; 
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (LecturaDatosEx e) {
			System.out.println("Error de acceso datos"); 
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} 
		System.out.println("Resultado: " + resultado);
		
	
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		// TODO Auto-generated method stub
		try {
			if(this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			}else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx e) {
			System.out.println("Error al iniciar catalogo de peliculas");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
