package SISDEEDIFICIO;

/**
 * Central nuclear: genera bastante energia pero es peligrosa si se deteriora.
 * Si su salud cae por debajo del 20% provoca una explosion que termina la partida.
 */
public class CentralNuclear extends EdificioIndustrial implements Mantenible {

    public CentralNuclear() {
        super("Central Nuclear", 10000, 0, 5000);
    }

    /** Produce 200 MW por mes */
    @Override
    public double producirRecurso() {
        return 200;
    }

    @Override
    public String getTipoRecurso() {
        return "Energia";
    }

    /**
     * Ademas de informar de su estado, comprueba si la salud es critica.
     * Por debajo del 20% lanza una excepcion que colapsa la ciudad.
     */
    @Override
    public void aplicarEfectoMensual() {
        System.out.println(nombre + " opera generando 200 MW. [Salud: " + salud + "%]");
        if (salud < 20) {
            throw new RuntimeException(
                "Explosion en la Central Nuclear. Su salud cayo al " + salud + "%. La ciudad ha colapsado."
            );
        }
    }

    @Override
    public void reparar() {
        salud = 100;
    }

    @Override
    public void desgastar(int cantidad) {
        salud -= cantidad;
        if (salud < 0) salud = 0;
        System.out.println("AVISO: " + nombre + " danada. Salud actual: " + salud + "%");
    }

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + "% | Produce: 200 MW | Reparacion: " + costeReparacion + "EUR]";
    }
}