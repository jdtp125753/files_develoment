package mundopc;

import com.jd.mundopc.*;

public class MundoPC {
	public static void main(String[] args) {
		Monitor monitorHP = new Monitor("HP", 13);
		Teclado tecladoHP = new Teclado("Bluetooth", "HP");
		Raton RatonHP = new Raton("Bluetooth", "HP");
		Computadora computadoraHP = new Computadora("Computadora HP: ", monitorHP, tecladoHP,RatonHP);//Esto se conoce como relación de agregación
	
		Monitor monitorGamer = new Monitor("Azus", 34);
		Teclado tecladoGamer = new Teclado("Bluetooth", "Gamer");
		Raton RatonGamer = new Raton("Bluetooth", "Azus");
		Computadora computadoraGamer = new Computadora("Computadora Gamer", monitorGamer, tecladoGamer,RatonGamer);//Esto se conoce como relación de agregación
	
		Orden orden1 = new Orden(); 
		orden1.agregarComputadora(computadoraHP);
		orden1.agregarComputadora(computadoraGamer);
		
		orden1.mostrarOrden();
	}
}
