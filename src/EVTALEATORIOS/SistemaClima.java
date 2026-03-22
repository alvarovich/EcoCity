package EVTALEATORIOS;

import java.util.Random;
import SISDECIUDAD.Ciudad;

public class SistemaClima {
	
	public static void generarEvento(Ciudad ciudad) {
		
		Random rnd = new Random();
		
		int evento = rnd.nextInt(3);
		
		switch (evento) {
			case 0:
				Eventos.tormentaElectrica (ciudad);
				break;
			case 1:
				Eventos.olaDeCalor(ciudad);
				break;
			case 2:
				Eventos.vientosFuertes(ciudad);
				break;
		}
	}
	
	
}
