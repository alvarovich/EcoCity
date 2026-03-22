package EVTALEATORIOS;

import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.Mantenible;
import SISDEEDIFICIO.ParqueEolico;

/** Define los tres eventos climaticos disponibles y su efecto sobre los edificios */
public class Eventos {

    /** Desgasta un 10% a todos los edificios que generan recursos */
    public static void tormentaElectrica(Ciudad ciudad) {
        System.out.println("Tormenta electrica: los generadores pierden el 10% de salud");
        for (Edificio e : ciudad.getEdificios()) {
            if (e instanceof GeneradorRecursos && e instanceof Mantenible) {
                ((Mantenible) e).desgastar(10);
            }
        }
    }

    /** Desgasta un 5% a todos los edificios mantenibles */
    public static void olaDeCalor(Ciudad ciudad) {
        System.out.println("Ola de calor: todos los edificios pierden un 5% de salud");
        for (Edificio e : ciudad.getEdificios()) {
            if (e instanceof Mantenible) {
                ((Mantenible) e).desgastar(5);
            }
        }
    }

    /** Desgasta un 15% solo a los parques eolicos */
    public static void vientosFuertes(Ciudad ciudad) {
        System.out.println("Vientos fuertes: los parques eolicos pierden un 15% de salud");
        for (Edificio e : ciudad.getEdificios()) {
            if (e instanceof ParqueEolico && e instanceof Mantenible) {
                ((Mantenible) e).desgastar(15);
            }
        }
    }
}