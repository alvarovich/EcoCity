package MTRJUEGO;

import java.util.Random;

public class SistemaClima {
	
	public static void generarEvento(Ciudad ciudad) {
		
		Random rnd = new Random();
		
		int evento = rnd.nextInt(3);
		
		switch (evento) {
			case 0:
				tormentaElectrica (ciudad);
				break;
			case 1:
				olaDeCalor(ciudad);
				break;
			case 2:
				vientosFuertes(ciudad);
				break;
		}
	}
	
	public static void tormentaElectrica(Ciudad ciudad) {
		System.out.println("Tormenta eléctrica inminente: los generadores pierden el 10% de su salud");
		
		for (Edificio e : ciudad.getEdificios()) {
			
			if (e instanceof GeneradorRecursos && e instanceof Mantenible) {
				
				Mantenible m = (Mantenible) e;
				m.desgastar(10);
			}
		}
	}
	
	public static void olaDeCalor (Ciudad ciudad) {
		
		System.out.println("Ola de calor: aumenta el consumo energético");
		
		for (Edificio e : ciudad.getEdificios()) {

	        if (e instanceof Mantenible) {

	            Mantenible m = (Mantenible) e;
	            m.desgastar(5);

	        }
		}
	}
	
	public static void vientosFuertes(Ciudad ciudad) {

	    System.out.println("🌪 Vientos fuertes afectan a parques eólicos");

	    for (Edificio e : ciudad.getEdificios()) {

	        if (e instanceof ParqueEolico && e instanceof Mantenible) {

	            Mantenible m = (Mantenible) e;
	            m.desgastar(15);

	        }

	    }

	}
}
