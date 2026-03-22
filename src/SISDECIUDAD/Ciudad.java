package SISDECIUDAD;

import java.util.ArrayList;
import SISDEEDIFICIO.Edificio;
import SISDEEDIFICIO.GeneradorRecursos;
import SISDEEDIFICIO.EdificioResidencial;
import SISDEEDIFICIO.EdificioComercial;
import EXCEPCIONES.FondosInsuficientesException;

/**
 * Representa la ciudad del jugador. Almacena los recursos globales
 * y la lista de edificios construidos.
 */
public class Ciudad {

    private int dinero;
    // La energia se acumula mes a mes sumando produccion y restando consumo
    private int energia;
    private int poblacion;
    private int felicidad;
    // Lista central de edificios, recorrida cada mes por el motor
    private ArrayList<Edificio> edificios;

    public Ciudad() {
        dinero    = 8000;
        energia   = 0;
        poblacion = 0;
        felicidad = 100;
        edificios = new ArrayList<>();
    }

    /**
     * Intenta construir un edificio descontando su coste.
     * Lanza FondosInsuficientesException si no hay dinero suficiente.
     * La energia no se modifica aqui, se actualiza al pasar mes.
     */
    public void agregarEdificio(Edificio edificio) throws FondosInsuficientesException {
        if (dinero < edificio.getCosto()) {
            throw new FondosInsuficientesException(
                "No tienes suficiente dinero para construir " + edificio.getNombre() +
                ". Necesitas " + edificio.getCosto() + "EUR y tienes " + dinero + "EUR."
            );
        }
        dinero -= edificio.getCosto();
        edificios.add(edificio);
        System.out.println(edificio.getNombre() + " construido. Costo: " + edificio.getCosto() + "EUR");
        System.out.println("Los efectos sobre la energia se aplicaran al pasar mes.");
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getEnergia() {
        return energia;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public int getFelicidad() {
        return felicidad;
    }

    /** Muestra el estado actual de la ciudad con todos sus recursos y edificios */
    public void mostrarEstado(int mes) {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("   ECOCITY - MES " + mes);
        System.out.println("══════════════════════════════════════");
        System.out.printf("  Dinero:     %dEUR%n", dinero);
        System.out.printf("  Energia:    %d MW%n", energia);
        System.out.printf("  Poblacion:  %d%n", poblacion);
        System.out.printf("  Felicidad:  %d%%%n", felicidad);
        System.out.println("--------------------------------------");
        if (edificios.isEmpty()) {
            System.out.println("  (Sin edificios construidos)");
        } else {
            System.out.println("  Edificios:");
            for (int i = 0; i < edificios.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + edificios.get(i));
            }
        }
        System.out.println("══════════════════════════════════════");
    }

    /**
     * Actualiza todos los recursos del mes acumulando sobre los valores anteriores.
     * Cada mes se suman las producciones y se restan los consumos sin resetear la energia,
     * de forma que el balance crece o decrece progresivamente segun los edificios activos.
     */
    public void calcularRecursos() {

        // Variables locales para mostrar el resumen del mes sin mezclar con el acumulado
        int produccionMes = 0;
        int consumoMes    = 0;

        for (Edificio e : edificios) {

            // Los generadores aportan energia al balance acumulado
            if (e instanceof GeneradorRecursos) {
                int producido = (int) ((GeneradorRecursos) e).producirRecurso();
                energia      += producido;
                produccionMes += producido;
                System.out.println("  " + e.getNombre() + " genera " + producido + " MW");
            }

            // Todos los edificios con consumo restan energia cada mes
            if (e.getConsumoEnergia() > 0) {
                energia    -= e.getConsumoEnergia();
                consumoMes += e.getConsumoEnergia();
                System.out.println("  " + e.getNombre() + " consume " + e.getConsumoEnergia() + " MW");
            }

            // Los residenciales generan poblacion e impuestos cada mes
            if (e instanceof EdificioResidencial) {
                poblacion += 50;
                dinero    += 200;
                System.out.println("  Impuestos recaudados: +200EUR");
            }

            // Los comerciales generan ingresos y suben la felicidad cada mes
            if (e instanceof EdificioComercial) {
                dinero    += 350;
                felicidad += 5;
                if (felicidad > 100) felicidad = 100;
                System.out.println("  Ingresos comerciales: +350EUR");
            }

            // Un edificio en ruinas penaliza la felicidad
            if (e.getSalud() == 0) {
                felicidad -= 5;
                if (felicidad < 0) felicidad = 0;
                System.out.println("  " + e.getNombre() + " en ruinas: -5 felicidad");
            }
        }

        // Mostramos el resumen energetico del mes
        System.out.println("--------------------------------------");
        System.out.println("  Produccion este mes: +" + produccionMes + " MW");
        System.out.println("  Consumo este mes:    -" + consumoMes    + " MW");
        System.out.println("  Energia acumulada:    " + energia       + " MW");

        // Si el balance acumulado es negativo la ciudad sufre apagones
        if (energia < 0) {
            felicidad -= 10;
            if (felicidad < 0) felicidad = 0;
            System.out.println("  Apagon: energia negativa, felicidad disminuye.");
        }
    }
}