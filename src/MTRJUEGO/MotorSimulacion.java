package MTRJUEGO;

import java.util.Scanner;

import EVTALEATORIOS.SistemaClima;
import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.ParqueEolico;
import SISDEEDIFICIO.CentralNuclear;
import SISDEEDIFICIO.EdificioResidencial;
import SISDEEDIFICIO.Mantenible;

public class MotorSimulacion {

    private Ciudad ciudad;
    private int mes;
    private Scanner sc;

    public MotorSimulacion() {
        ciudad = new Ciudad();
        mes = 1;
        sc = new Scanner(System.in);
    }

    public void iniciar() {

        boolean ejecutando = true;

        while (ejecutando) {

            ciudad.mostrarEstado(mes);
            mostrarMenu();

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    construir();
                    break;

                case 2:
                    reparar();
                    break;

                case 3:
                    cicloMensual();
                    break;

                case 4:
                    ejecutando = false;
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Elige una opción del menú");
                    break;
            }
        }
    }

    private void mostrarMenu() {

        System.out.println("\n¿Qué desea hacer?");
        System.out.println("1. Construir");
        System.out.println("2. Reparar");
        System.out.println("3. Pasar Mes");
        System.out.println("4. Guardar y Salir");
    }

    // ✅ MÉTODO CONSTRUIR
    private void construir() {

        System.out.println("¿Qué edificio quieres construir?");
        System.out.println("1. Parque Eólico");
        System.out.println("2. Central Nuclear");
        System.out.println("3. Residencial");

        int opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                ciudad.agregarEdificio(new ParqueEolico());
                break;

            case 2:
                ciudad.agregarEdificio(new CentralNuclear());
                break;

            case 3:
                ciudad.agregarEdificio(new EdificioResidencial("Casa", 2000, 20, 100));
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    // ✅ MÉTODO REPARAR
    private void reparar() {

        System.out.println("Selecciona el edificio a reparar:");

        for (int i = 0; i < ciudad.getEdificios().size(); i++) {
            System.out.println((i + 1) + ". " + ciudad.getEdificios().get(i));
        }

        int index = sc.nextInt() - 1;

        if (index >= 0 && index < ciudad.getEdificios().size()) {

            Edificio e = ciudad.getEdificios().get(index);

            if (e instanceof Mantenible) {
                Mantenible m = (Mantenible) e;
                m.reparar();
                System.out.println("Edificio reparado");
            } else {
                System.out.println("Este edificio no se puede reparar");
            }

        } else {
            System.out.println("Selección inválida");
        }
    }

    private void cicloMensual() {

        try {

            ciudad.calcularRecursos();

            for (Edificio e : ciudad.getEdificios()) {
                e.aplicarEfectoMensual();
            }

            SistemaClima.generarEvento(ciudad);

            mes++;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("La ciudad ha colapsado...");
        }
    }
}