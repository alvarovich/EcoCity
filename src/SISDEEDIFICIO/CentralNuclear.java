package SISDEEDIFICIO;

public class CentralNuclear extends EdificioIndustrial implements Mantenible {

    public CentralNuclear() {
        super("Central Nuclear", 10000, 0, 5000);
    }

    @Override
    public double producirRecurso() {
        return 500;
    }

    @Override
    public String getTipoRecurso() {
        return "Energia";
    }

    @Override
    public void aplicarEfectoMensual() {
        System.out.println(nombre + " opera generando 500 MW. [Salud: " + salud + "%]");
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
        return nombre + " [Salud: " + salud + "% | Produce: 500 MW | Reparacion: " + costeReparacion + "EUR]";
    }
}