package SISDEEDIFICIO;

public class ParqueEolico extends EdificioIndustrial implements Mantenible {

    public ParqueEolico() {
        super("Parque Eolico", 3000, 0, 800);
    }

    @Override
    public double producirRecurso() {
        return 120;
    }

    @Override
    public String getTipoRecurso() {
        return "Energia";
    }

    @Override
    public void aplicarEfectoMensual() {
        System.out.println(nombre + " genera energia eolica. [Salud: " + salud + "%]");
    }

    @Override
    public void reparar() {
        salud = 100;
    }

    @Override
    public void desgastar(int cantidad) {
        salud -= cantidad;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " danado. Salud actual: " + salud + "%");
    }

    @Override
    public String toString() {
        return nombre + " [Salud: " + salud + "% | Produce: 120 MW | Reparacion: " + costeReparacion + "EUR]";
    }
}