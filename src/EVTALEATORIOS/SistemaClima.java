package EVTALEATORIOS;

import java.util.Random;
import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.Mantenible;
import SISDEEDIFICIO.ParqueEolico;

/** Selecciona y lanza un evento climatico aleatorio cada mes */
public class SistemaClima {

    /** Elige aleatoriamente uno de los tres eventos y lo ejecuta */
    public static void generarEvento(Ciudad ciudad) {
        Random r = new Random();
        int evento = r.nextInt(3);
        switch (evento) {
            case 0: tormentaElectrica(ciudad); break;
            case 1: olaCalor(ciudad);          break;
            case 2: vientoFuerte(ciudad);      break;
        }
    }

    /** Desgasta un 10% a los edificios generadores de recursos */
    private static void tormentaElectrica(Ciudad ciudad) {
        System.out.println("Tormenta electrica");
        for (Edificio e : ciudad.getEdificios()) {
            if (e instanceof GeneradorRecursos && e instanceof Mantenible) {
                ((Mantenible) e).desgastar(10);
            }
        }
    }

    /** Desgasta un 5% a todos los edificios mantenibles */
    private static void olaCalor(Ciudad ciudad) {
        System.out.println("Ola de calor");
        for (Edificio e : ciudad.getEdificios()) {
            if (e instanceof Mantenible) {
                ((Mantenible) e).desgastar(5);
            }
        }
    }

    /** Desgasta un 15% solo a los parques eolicos */
    private static void vientoFuerte(Ciudad ciudad) {
        System.out.println("Vientos fuertes");
        for (Edificio e : ciudad.getEdificios()) {
            if (e instanceof ParqueEolico && e instanceof Mantenible) {
                ((Mantenible) e).desgastar(15);
            }
        }
    }
}