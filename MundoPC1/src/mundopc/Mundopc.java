package mundopc;

import com.jd.mundopc.*;

public class Mundopc {
	public static void main(String[] args) {
		Monitor monitorHP = new Monitor("HP", 13);
		Teclado tecladoHP = new Teclado("bluetooth", "HP" );
		Raton ratonHP = new Raton("bluetooth", "HP" );
		Computadora computadoraHP = new Computadora("ComputadoraHP", monitorHP, tecladoHP, ratonHP);
	
		Monitor monitorGamer = new Monitor("Gamer", 32);
		Teclado tecladoGamer = new Teclado("bluetooth", "Gamer" );
		Raton ratonGamer = new Raton("bluetooth", "Gamer" );
		Computadora computadoraGamer = new Computadora("ComputadoraGamer", monitorGamer, tecladoHP, ratonGamer);
	
		Orden orden = new Orden(); 
		
		orden.agregarComputadora(computadoraHP);
		orden.agregarComputadora(computadoraGamer);
		
		orden.mostrarOrden();
		
	}
}
