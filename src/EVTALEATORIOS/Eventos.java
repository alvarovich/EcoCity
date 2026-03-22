package EVTALEATORIOS;

import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.Mantenible;
import SISDEEDIFICIO.ParqueEolico; 

public class Eventos {
	
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
