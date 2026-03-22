package MTRJUEGO;

import java.util.Scanner;

import EVTALEATORIOS.SistemaClima;
import EXCEPCIONES.FondosInsuficientesException;
import PERSISTENCIA.GestorPartidas;
import SISDECIUDAD.Ciudad;
import SISDEEDIFICIO.*;
import SISUSUARIOS.*;

public class MotorSimulacion {

    private Ciudad ciudad;
    private int mes;
    private Scanner sc;
    private SisUsuarios sisUsuarios;
    private GestorPartidas gestorPartidas;

    public MotorSimulacion() {
        ciudad         = new Ciudad();
        mes            = 1;
        sc             = new Scanner(System.in);
        sisUsuarios    = new SisUsuarios();
        gestorPartidas = new GestorPartidas();
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        sisUsuarios.regUsuario(new Jugador("jugador1", "1234"));
    }

    public void iniciar() {

        System.out.println("╔══════════════════════════╗");
        System.out.println("║   BIENVENIDO A ECOCITY   ║");
        System.out.println("╚══════════════════════════╝");

        Usuario usuarioActual = null;

        while (usuarioActual == null) {
            System.out.print("\nNombre de usuario: ");
            String nombre = sc.next();
            System.out.print("Contrasena:        ");
            String pass   = sc.next();

            usuarioActual = sisUsuarios.login(nombre, pass);

            if (usuarioActual == null) {
                System.out.println("Usuario o contrasena incorrectos. Intentalo de nuevo.");
            }
        }

        System.out.println("\nSesion iniciada como: " + usuarioActual.getNombreUsuario()
                + " [" + usuarioActual.getRol() + "]");

        if (usuarioActual instanceof Jugador) {
            ((Jugador) usuarioActual).sumarPartida();
        }

        boolean ejecutando = true;

        while (ejecutando) {
            ciudad.mostrarEstado(mes);
            mostrarMenu();

            int opcion;
            try {
                opcion = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1: construir();    break;
                case 2: reparar();      break;
                case 3: cicloMensual(); break;
                case 4:
                    guardarYSalir(usuarioActual);
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Elige una opcion del menu.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n¿Que deseas hacer?");
        System.out.println("  1. Construir edificio");
        System.out.println("  2. Reparar edificio");
        System.out.println("  3. Pasar mes");
        System.out.println("  4. Guardar y salir");
        System.out.print("Opcion: ");
    }

    private void construir() {
        System.out.println("\n¿Que edificio quieres construir?");
        System.out.println("  1. Parque Eolico          (3.000EUR | +120 MW)");
        System.out.println("  2. Central Nuclear        (10.000EUR | +500 MW)");
        System.out.println("  3. Barrio Residencial     (2.000EUR | +50 hab/mes | +500EUR/mes)");
        System.out.println("  4. Centro Comercial       (4.000EUR | +800EUR/mes | +5 felicidad)");
        System.out.print("Opcion: ");

        int opcion;
        try {
            opcion = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Opcion invalida.");
            return;
        }

        try {
            switch (opcion) {
                case 1: ciudad.agregarEdificio(new ParqueEolico());   break;
                case 2: ciudad.agregarEdificio(new CentralNuclear()); break;
                case 3: ciudad.agregarEdificio(new EdificioResidencial("Barrio Residencial", 2000, 20, 100)); break;
                case 4: ciudad.agregarEdificio(new EdificioComercial()); break;
                default: System.out.println("Opcion invalida.");
            }
        } catch (FondosInsuficientesException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reparar() {
        if (ciudad.getEdificios().isEmpty()) {
            System.out.println("No hay edificios construidos.");
            return;
        }

        System.out.println("\nSelecciona el edificio a reparar:");
        for (int i = 0; i < ciudad.getEdificios().size(); i++) {
            System.out.println("  " + (i + 1) + ". " + ciudad.getEdificios().get(i));
        }
        System.out.print("Opcion: ");

        int index;
        try {
            index = Integer.parseInt(sc.next()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Opcion invalida.");
            return;
        }

        if (index >= 0 && index < ciudad.getEdificios().size()) {
            Edificio e = ciudad.getEdificios().get(index);

            if (e instanceof Mantenible) {

                if (e.getSalud() == 100) {
                    System.out.println(e.getNombre() + " ya esta en perfecto estado, no necesita reparacion.");
                    return;
                }

                int coste = e.getCosteReparacion();

                if (ciudad.getDinero() < coste) {
                    System.out.println("No tienes suficiente dinero para reparar " + e.getNombre() +
                            ". Necesitas " + coste + "EUR y tienes " + ciudad.getDinero() + "EUR.");
                    return;
                }

                ciudad.setDinero(ciudad.getDinero() - coste);
                ((Mantenible) e).reparar();
                System.out.println(e.getNombre() + " reparado por " + coste + "EUR. Salud: 100%");

            } else {
                System.out.println("Este edificio no es mantenible.");
            }
        } else {
            System.out.println("Seleccion invalida.");
        }
    }

    private void cicloMensual() {
        System.out.println("\nProcesando mes " + mes + "...");

        try {
            ciudad.calcularRecursos();

            for (Edificio e : ciudad.getEdificios()) {
                e.aplicarEfectoMensual();
            }

            SistemaClima.generarEvento(ciudad);
            mes++;

        } catch (RuntimeException e) {
            System.out.println("CATASTROFE: " + e.getMessage());
            System.out.println("La ciudad ha colapsado. Fin de la partida.");
            System.exit(0);
        }
    }

    private void guardarYSalir(Usuario usuario) {
        String ruta = "partida_" + usuario.getNombreUsuario() + ".txt";
        gestorPartidas.guardarPartida(ciudad, ruta);
        System.out.println("Hasta pronto, " + usuario.getNombreUsuario() + "!");
    }
}