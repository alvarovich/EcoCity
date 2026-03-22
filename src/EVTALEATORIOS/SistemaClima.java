package EVTALEATORIOS;

import java.util.Random;

import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.Mantenible;
import SISDEEDIFICIO.ParqueEolico;

public class SistemaClima {

    public static void generarEvento(Ciudad ciudad) {

        Random r = new Random();
        int evento = r.nextInt(3);

        switch (evento) {

            case 0:
                tormentaElectrica(ciudad);
                break;

            case 1:
                olaCalor(ciudad);
                break;

            case 2:
                vientoFuerte(ciudad);
                break;
        }
    }

    private static void tormentaElectrica(Ciudad ciudad) {

        System.out.println("Tormenta eléctrica");

        for (Edificio e : ciudad.getEdificios()) {

            if (e instanceof GeneradorRecursos && e instanceof Mantenible) {
                ((Mantenible) e).desgastar(10);
            }
        }
    }

    private static void olaCalor(Ciudad ciudad) {

        System.out.println("Ola de calor");

        for (Edificio e : ciudad.getEdificios()) {

            if (e instanceof Mantenible) {
                ((Mantenible) e).desgastar(5);
            }
        }
    }

    private static void vientoFuerte(Ciudad ciudad) {

        System.out.println("Vientos fuertes");

        for (Edificio e : ciudad.getEdificios()) {

            if (e instanceof ParqueEolico && e instanceof Mantenible) {
                ((Mantenible) e).desgastar(15);
            }
        }
    }
}