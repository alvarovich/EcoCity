package SISDEEDIFICIO;

public class CentralNuclear extends EdificioIndustrial implements Mantenible {

    public CentralNuclear() {
        super("Central Nuclear", 10000, 0);
    }

    @Override
    public double producirRecurso() {
        return 500;
    }

    @Override
    public String getTipoRecurso() {
        return "Energía";
    }

    @Override
    public void aplicarEfectoMensual() {
        System.out.println(nombre + " opera generando 500 unidades de energía. [Salud: " + salud + "%]");
        if (salud < 20) {
            throw new RuntimeException(
                "¡Explosión en la Central Nuclear! Su salud cayó al " + salud + "%. ¡La ciudad ha colapsado!"
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
        System.out.println(nombre + " dañada. Salud actual: " + salud + "%");
    }

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + "% | Produce: 500 energía]";
    }
}